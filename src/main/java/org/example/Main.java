package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Homework homework = new Homework();

        System.out.println(homework.removeSpecificName(List.of("Anna", "Alex", "Anna"), "Anna" ));
        }
    }