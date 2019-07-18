package org.crackthecode.chapter01.arrayandstrings;

public class Tester {
    public static void main(String[] args) {
        String[] words = {"first", "second", "third", "unic", "cuin"};

        System.out.println("<====== cycle do-while ========>");
        int count = 0;
        do {
            System.out.println("Item[" + count + "] =" + words[count]);
            count = count + 1;
        }while ( count < words.length);

        System.out.println("<======= cycle for ======>");
        for (String s: words){
            System.out.println(s);
        }
    }

}
