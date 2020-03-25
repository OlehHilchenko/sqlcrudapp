package com.olehhilchenko.view;

import com.olehhilchenko.controller.DeveloperController;

public class MainMenuActions {


    private DeveloperController developerController = new DeveloperController();


    public void mainMenuActions() {
        boolean endPerformance = false;
        int numberOfChoice;
        do {
            PrintPartOfTheMenu.viewMainMenu();
            numberOfChoice = PrintPartOfTheMenu.integerScanner();
            switch (numberOfChoice) {
                case (1):
                    developerController.addDeveloper();
                    break;
                case (2):
                    developerController.viewDeveloper();
                    break;
                case (3):
                    developerController.removeDeveloper();
                    break;
                case (4):
                    developerController.updateDeveloper();
                    break;
                case (5):
                    endPerformance = true;
                    break;
                default:
                    break;
            }
        }
        while (!endPerformance);
    }
}
