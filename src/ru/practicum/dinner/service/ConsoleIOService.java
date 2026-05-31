package ru.practicum.dinner.service;

import java.util.Scanner;

public final class ConsoleIOService {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readNumber() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static int readNumberWithPrompt(String prompt) {
        System.out.println(prompt);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String readString() {
        return scanner.nextLine();
    }

    public static String readStringWithPrompt(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
}
