package org.examples.client;

import org.examples.web.Student;

import java.io.*;//импорт пакета, содержащего классы для // ввода/вывода
import java.net.*;//импорт пакета, содержащего классы для // работы в сети
import java.util.ArrayList;
import java.util.List;


public class client {

    public static void main(String[] arg) {
        try {
            System.out.println("server connecting....");
            Socket clientSocket = new Socket("127.0.0.1", 8989);//установление //соединения между локальной машиной и указанным портом узла сети

            System.out.println("connection established....");
            BufferedReader stdin =
                    new BufferedReader(new InputStreamReader(System.in));//создание 

            //буферизированного символьного потока ввода
            ObjectOutputStream coos = new ObjectOutputStream(clientSocket.getOutputStream());//создание потока вывода
            ObjectInputStream cois = new ObjectInputStream(clientSocket.getInputStream());//создание потока ввода

            System.out.println("Enter any string to send to server \n\t('quite' − programme terminate)");
            String clientMessage = stdin.readLine();


            List<Student> studentList = new ArrayList<Student>();
            //List<Student> objectList = null;

            studentList.add(new Student("Ivan", 19, 1));
            studentList.add(new Student("Vasia", 20, 2));
            studentList.add(new Student("Petia", 19, 2));
            studentList.add(new Student("Taras", 21, 3));

            System.out.println("you've entered: " + clientMessage);
            System.out.println("will send:" + studentList);


            while (!clientMessage.equals("quite")) {//выполнение цикла, пока строка //не будет равна «quite»

                coos.writeObject(studentList);//потоку вывода присваивается //значение строковой переменной (передается серверу)
                System.out.println("~server~: " + cois.readObject());//выводится на //экран со-держимое потока ввода (переданное сервером)
                System.out.println("---------------------------");
                clientMessage = stdin.readLine();//ввод текста с клавиатуры
                System.out.println("you've entered: " + clientMessage);//вывод в //консоль строки и значения строковой переменной
            }
            coos.close();//закрытие потока вывода
            cois.close();//закрытие потока ввода

            clientSocket.close();//закрытие сокета
        } catch (Exception e) {
            e.printStackTrace();//выполнение метода исключения е
        }
    }
}
