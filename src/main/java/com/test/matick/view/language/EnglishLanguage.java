package com.test.matick.view.language;

public class EnglishLanguage extends Language {

    @Override
    public String greetingMessage() {
        return "Welcome to the system";
    }

    @Override
    public String generateNewFiguresMenuItemTitle() {
        return "Generate new figures";
    }

    @Override
    public String showInfoFiguresMenuItemTitle() {
        return "Show information about all figures";
    }

    @Override
    public String showInfoFigureMenuItemTitle() {
        return "Show information about the a certain figure";
    }

    @Override
    public String deleteAllFiguresMenuItemTitle() {
        return "Delete all figures";
    }

    @Override
    public String shutdownMenuItemTitle() {
        return "Turn off the program";
    }

    @Override
    public String chooseMenuItemMessage() {
        return "Enter your choice";
    }

    @Override
    public String infoMessageFiguresNotFoundMessage() {
        return "Information about figures not found";
    }

    @Override
    public String errorMessage() {
        return "Oops... something wrong";
    }

    @Override
    public String enterCountFiguresMessage() {
        return "Enter count of figures";
    }

    @Override
    public String successfullyGenerateFiguresMessage() {
        return "Figures were successfully generated";
    }

    @Override
    public String successfullyDeleteFiguresMessage() {
        return "Figures were successfully deleted";
    }

    @Override
    public String pressAnyKeyToContinueContinueMessage() {
        return "Press any key to continue";
    }

    @Override
    public String confirmationRequestMessage() {
        return "Are you sure?";
    }

    @Override
    public String chooseIndexMessage() {
        return "Choose index";
    }

    @Override
    public String farewellMessage() {
        return "Goodbye";
    }
}
