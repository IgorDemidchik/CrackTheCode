package org.crackthecode.chapter01.arrayandstrings;

public class Account {
    String name;
    float money;

    public Account(String name, float money) {
        this.name = name;
        this.money = money;
    }

    public Account() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}

