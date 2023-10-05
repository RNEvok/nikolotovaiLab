package reliab.course.nikolotovai.bank;

import reliab.course.nikolotovai.bank.entity.Bank;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello world!");
        Bank bank = new Bank(10, "hehe");
        System.out.println(bank.toString());
    }
}