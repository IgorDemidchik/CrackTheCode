package org.examples.server;

import org.examples.web.Student;

import java.io.*;//импорт пакета, содержащего классы для //ввода/вывода

import java.net.*;//импорт пакета, содержащего классы для работы в  //сети Internet
import java.util.List;

public class server {

    public static void main(String[] arg) {//объявление объекта класса ServerSocket

        ServerSocket serverSocket = null;
        Socket clientAccepted = null;//объявление объекта класса Socket
        ObjectInputStream sois = null;//объявление байтового потока ввода
        ObjectOutputStream soos = null;//объявление байтового потока вывода

        try {
            System.out.println("server starting....");
            serverSocket = new ServerSocket(8989);//создание сокета сервера для //заданного порта
            clientAccepted = serverSocket.accept();//выполнение метода, который //обеспечивает реальное подключение сервера к клиенту
            System.out.println("connection established....");

            List<Student> clientMessageRecieved = null;


            //создание потока ввода soos = new 
            sois = new ObjectInputStream(clientAccepted.getInputStream());
            soos = new ObjectOutputStream(clientAccepted.getOutputStream());//создание потока //вывода

             clientMessageRecieved = (List<Student>) sois.readObject();//объявление //строки и присваивание ей данных потока ввода, представленных
                        //в виде строки (передано клиентом)
            while (!clientMessageRecieved.isEmpty())//выполнение цикла: пока
            //строка не будет равна «quite»
            {
                System.out.println("message recieved: '" + clientMessageRecieved + "'");

                //clientMessageRecieved = clientMessageRecieved.toUpperCase();//приведение символов строки к //верхнему регистру

                soos.writeObject(clientMessageRecieved);//потоку вывода //присваивается значение строковой переменной (передается клиенту)

                //clientMessageRecieved = (String) sois.readObject();//строке //присваиваются данные потока ввода, представленные в виде строки
                    //(передано клиентом)
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                sois.close();//закрытие потока ввода
                soos.close();//закрытие потока вывода
                clientAccepted.close();//закрытие сокета, выделенного для клиента
                serverSocket.close();//закрытие сокета сервера
            } catch (Exception e) {
                e.printStackTrace();//вызывается метод исключения е
            }
        }
    }
}
