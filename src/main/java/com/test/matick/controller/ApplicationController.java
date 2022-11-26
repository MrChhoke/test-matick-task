package com.test.matick.controller;

import com.test.matick.model.figure.Figure;
import com.test.matick.model.generator.RandomGeneratorFigure;
import com.test.matick.view.menu.ConsoleMenu;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ApplicationController {

    private boolean isWorking = true;
    private final ConsoleMenu consoleMenu = new ConsoleMenu();
    private final Scanner scanner = new Scanner(System.in);
    private final RandomGeneratorFigure generatorFigures = new RandomGeneratorFigure();
    private List<Figure> figures;

    public void start() {
        while (isWorking) {
            consoleMenu.clearScreen();
            consoleMenu.showMainMenu();

            consoleMenu.chooseMenuItem();
            int menuItem;

            try {
                menuItem = scanner.nextInt();
            } catch (Exception e) {
                consoleMenu.showError();
                pause();
                scanner.nextLine();
                continue;
            }

            consoleMenu.clearScreen();
            switch (menuItem) {
                case 1:
                    showInfoAboutFigures();
                    break;
                case 2:
                    showFigureByIndex();
                    break;
                case 3:
                    generateFigures();
                    break;
                case 4:
                    deleteAllFigures();
                    break;
                case 5:
                    turnOffProgram();
            }
        }
    }

    public void showInfoAboutFigures() {
        consoleMenu.showInfoAboutFigures(figures);
        pause();
    }

    public void showFigureByIndex() {
        if (consoleMenu.showAvailableIndexFigures(figures)) {
            int index;

            try {
                index = scanner.nextInt();
            } catch (Exception exception) {
                consoleMenu.showError();
                pause();
                scanner.nextLine();
                return;
            }

            if (index < 0 || index >= figures.size()) {
                consoleMenu.showError();
                pause();
                return;
            }

            consoleMenu.showInfoAboutFigure(figures.get(index));
        }
        pause();
    }

    public void generateFigures() {
        consoleMenu.chooseCountGeneratedFigures();
        int countFigures;

        try {
            countFigures = scanner.nextInt();
        } catch (Exception exception) {
            consoleMenu.showError();
            pause();
            scanner.nextLine();
            return;
        }

        if (countFigures < 0) {
            consoleMenu.showError();
            pause();
            return;
        }

        figures = generatorFigures.generateRandomFigures(countFigures);
        consoleMenu.creationFigures();
        pause();
    }

    public void deleteAllFigures() {
        consoleMenu.confirmationRequest();
        scanner.nextLine();
        boolean isApprove = scanner.nextLine().trim().equals("+");

        if (isApprove) {
            figures = null;
            consoleMenu.deletionFigures();
        }

        pause();
    }

    public void turnOffProgram() {
        isWorking = false;
        consoleMenu.farewell();
        pause();
    }

    private void pause() {
        consoleMenu.pause();
        try {
            System.in.read();
        } catch (IOException ignored) {
        }
    }
}
