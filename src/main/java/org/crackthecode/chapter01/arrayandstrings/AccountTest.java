package org.crackthecode.chapter01.arrayandstrings;

import java.util.*;

public class AccountTest {
    public static void main(String[] args){
        Account[] accounts = new Account[5];
        List<Account> accountList = new ArrayList<Account>();

        for ( Account act : accounts) {
            System.out.println(act);
        }

    }

}
