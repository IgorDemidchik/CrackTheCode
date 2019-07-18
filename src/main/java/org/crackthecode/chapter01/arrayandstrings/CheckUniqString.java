package org.crackthecode.chapter01.arrayandstrings;

public class CheckUniqString {

    public static boolean checkTheString(String str){
        int[] infoArray = new int[128];
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == ' ') continue;;

            if (infoArray[str.charAt(i)] != 0) {
                return false;
            } else {
                infoArray[str.charAt(i)] = 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strExamples = {"This world man", "Hello World!", "hello", "tesst", "example", "checkdunigue", "abcdef"};

        int i = 0;
        for (String s: strExamples ) {
            System.out.print("word["+ i++ + "] = " + s + ",");
            String sOut = checkTheString(s)? "is unique" : "is NOT unique";
            System.out.println(sOut);
        }
    }
}
