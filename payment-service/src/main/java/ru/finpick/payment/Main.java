package ru.finpick.payment;

import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.finpick.payment.external")
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}