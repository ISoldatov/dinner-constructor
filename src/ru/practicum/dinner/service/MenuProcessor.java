package ru.practicum.dinner.service;

import java.util.ArrayList;

public class MenuProcessor {
    private final DinnerConstructor dinnerConstructor;

    public MenuProcessor() {
        this.dinnerConstructor = new DinnerConstructor();
    }

    public void addNewDish() {
        String dishType = ConsoleIOService.readStringWithPrompt("Введите тип блюда:");
        String dishName = ConsoleIOService.readStringWithPrompt("Введите название блюда:");
        dinnerConstructor.addNewDish(dishType, dishName);
    }

    public void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");
        int numberOfCombos = ConsoleIOService.readNumberWithPrompt("Введите количество наборов, которые нужно сгенерировать:");
        ArrayList<String> selectedTypes = selectTypeDishesForCombos();
        ArrayList<ArrayList<String>> generatedCombos = generateCombos(numberOfCombos, selectedTypes);
        printCombos(numberOfCombos, generatedCombos);
    }

    private ArrayList<String> selectTypeDishesForCombos() {
        String nextItem = ConsoleIOService.readStringWithPrompt("Вводите типы блюда, разделяя символом переноса строки (enter). " +
                "Для завершения ввода введите пустую строку");
        ArrayList<String> selectedTypes = new ArrayList<>();
        while (!nextItem.isEmpty()) {
            if (dinnerConstructor.checkType(nextItem)) {
                selectedTypes.add(nextItem);
            } else {
                System.out.println("Такой тип блюд мы еще не умеем готовить. Попробуйте что-нибудь другое!");
            }
            nextItem = ConsoleIOService.readString();
        }
        return selectedTypes;
    }

    private ArrayList<ArrayList<String>> generateCombos(int numberOfCombos, ArrayList<String> selectedTypes) {
        return dinnerConstructor.generateCombos(numberOfCombos, selectedTypes);
    }

    private void printCombos(int numberOfCombos, ArrayList<ArrayList<String>> generatedCombos) {
        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println("Комбинация " + (i + 1));
            System.out.println(generatedCombos.get(i));
        }
    }
}
