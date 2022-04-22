package com.pwr;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Abc abc = new Abc(26);

        System.out.println("%n*** Calculating number of different passwords for different password length (English Alphabet)%n");
        IntStream.range(1,27).forEach(n -> System.out.printf("Password length: %d -> Passwords combinations: %s%n", n, abc.calcMaxPossiblePasswords(n)));
    }
}
