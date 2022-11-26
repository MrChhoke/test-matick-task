package com.test.matick.view.menu;

import com.test.matick.model.figure.Figure;
import com.test.matick.view.language.Language;

import java.util.List;

public final class ConsoleMenu {

    private final Language language = new Language();

    public void clearScreen() {
        for (int i = 0; i < 5; i++) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
        }
    }

    public void showMainMenu() {
        System.out.println(language.greetingMessage());
        System.out.println(language.showInfoFiguresMenuItemTitle() + " - 1");
        System.out.println(language.showInfoFigureMenuItemTitle() + " - 2");
        System.out.println(language.generateNewFiguresMenuItemTitle() + " - 3");
        System.out.println(language.deleteAllFiguresMenuItemTitle() + " - 4");
        System.out.println(language.shutdownMenuItemTitle() + " - 5");
    }

    public void chooseMenuItem() {
        System.out.print(language.chooseMenuItemMessage() + ": ");
    }

    public void showInfoAboutFigures(List<Figure> figures) {
        if (figures == null || figures.size() == 0) {
            System.out.println(language.infoMessageFiguresNotFoundMessage());
            return;
        }

        for (Figure figure : figures) {
            showInfoAboutFigure(figure);
        }
    }

    public void showInfoAboutFigure(Figure figure) {
        System.out.println(figure);
    }

    /**
     * @return true if a container contains figures else it will return false
     */
    public boolean showAvailableIndexFigures(List<Figure> figures) {
        if (figures == null || figures.size() == 0) {
            System.out.println(language.infoMessageFiguresNotFoundMessage());
            return false;
        }

        System.out.print(language.chooseIndexMessage() + " (" + 0 + "-" + (figures.size() - 1) + ") : ");
        return true;
    }

    public void chooseCountGeneratedFigures() {
        System.out.print(language.enterCountFiguresMessage() + ": ");
    }

    public void creationFigures() {
        System.out.println(language.successfullyGenerateFiguresMessage());
    }

    public void deletionFigures() {
        System.out.println(language.successfullyDeleteFiguresMessage());
    }

    public void confirmationRequest() {
        System.out.print(language.confirmationRequestMessage() + " (+ / -): ");
    }

    public void farewell() {
        System.out.println(language.farewellMessage());
    }

    public void showError() {
        System.out.println(language.errorMessage());
    }

    public void pause() {
        System.out.print(language.pressAnyKeyToContinueContinueMessage());
    }
}
