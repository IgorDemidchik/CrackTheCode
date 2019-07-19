package org.crackthecode.chapter01.arrayandstrings;

import org.examples.web.Account;
import org.examples.web.Student;

import java.io.*;
import java.util.*;

public class AccountTest {
    public static void main(String[] args){
        Account[] accounts = new Account[5];

        List<Account> accountList = new ArrayList<Account>();
        List<Student> studentList = new ArrayList<Student>();
        List<Student> objectList = null;

        studentList.add(new Student("Ivan", 19, 1));
        studentList.add(new Student("Vasia", 20, 2));
        studentList.add(new Student("Petia", 19, 2));
        studentList.add(new Student("Taras", 21, 3));


        accountList.add(new Account("Ivan", 1.0f));
        accountList.add(new Account("Vasia", (float) 11.0));
        accountList.add(new Account("Petia",100));
        accountList.add(new Account("Semen",10));
        accountList.add(new Account("Taras",10));


        for ( Account act : accountList) {
            System.out.println(act);
        }

        System.out.println("Print Students:");

        for (Student item : studentList) {
            System.out.println(item);
        }

        Collections.sort(studentList);

        System.out.println("Print sorted students:");

        for (Student item : studentList) {
            System.out.println(item);
        }


        try {
            FileOutputStream fos = new FileOutputStream("account_file.div");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);

            fos.close();
            oos.close();


        } catch (Exception e)
        {
            System.out.println(e);

        }

        System.out.println("Read from file");


        try {
            FileInputStream fis = new FileInputStream("account_file.div");
            ObjectInputStream ois = new ObjectInputStream(fis);
            objectList = (List<Student>)ois.readObject();

            System.out.println("list from file:");

            for (Student item : objectList) {
                System.out.println(item);
            }

        } catch (IOException ex) {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
