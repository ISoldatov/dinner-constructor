package ru.practicum.dinner.service;

public class ApplicationRunner {
    private final MenuProcessor menuProcessor;

    public ApplicationRunner() {
        this.menuProcessor = new MenuProcessor();
    }

    public void run() {
        while (true) {
            printMenu();
            int command = ConsoleIOService.readNumber();
            switch (command) {
                case 1:
                    menuProcessor.addNewDish();
                    break;
                case 2:
                    menuProcessor.generateDishCombo();
                    break;
                case 3:
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }
}
