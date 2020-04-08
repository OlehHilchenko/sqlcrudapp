package com.olehhilchenko.view;

import com.olehhilchenko.controller.Controller;

public class MainMenuActions {


    private Controller controller = new Controller();


    public void mainMenuActions() {
        boolean endPerformance = false;
        int numberOfChoice;
        do {
            PrintPartOfTheMenu.viewMainMenu();
            numberOfChoice = PrintPartOfTheMenu.integerScanner();
            switch (numberOfChoice) {
                case (1):
                    controller.addDeveloper();
                    break;
                case (2):
                    controller.viewDeveloper();
                    break;
                case (3):
                    controller.removeDeveloper();
                    break;
                case (4):
                    controller.updateDeveloper();
                    break;
                case (5):
                    controller.viewAllDeveloper();
                    break;
                case (6):
                    endPerformance = true;
                    break;
                default:
                    break;
            }
        }
        while (!endPerformance);
    }
}
