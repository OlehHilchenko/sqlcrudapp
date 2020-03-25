package com.olehhilchenko.view;

import java.util.Scanner;

public class PrintPartOfTheMenu {
    public static final String ENTER_FIRST_NAME = "Enter First name:";
    public static final String ENTER_UPDATED_FIRST_NAME = "Enter updated First name:";
    public static final String ENTER_LAST_NAME = "Enter Last name:";
    public static final String ENTER_UPDATED_LAST_NAME = "Enter updated Last name:";
    public static final String ENTER_SPECIALTY_NAME = "Enter Specialty name:";
    public static final String ENTER_UPDATED_SPECIALTY_NAME = "Enter updated Specialty name:";
    public static final String ENTER_SPECIALTY_DESCRIPTION = "Enter Specialty Description:";
    public static final String ENTER_UPDATED_SPECIALTY_DESCRIPTION = "Enter updated Specialty Description:";
    public static final String ENTER_SKILL_NAME = "Enter Skill name:";
    public static final String ENTER_UPDATED_SKILL_NAME = "Enter updated Skill name:";
    public static final String ENTER_1_TO_ADD_NEXT_SKILL_OR_0_TO_SKIP_NEXT_SKILL = "Enter 1 to add next skill, or 0 to skip next skill:";
    public static final String ENTER_THE_ID_OF_THE_DEVELOPER_WHOSE_DATA_YOU_WANT_TO_SEE = "Enter the id of the developer whose data you want to see:";
    public static final String ENTER_THE_ID_OF_THE_DEVELOPER_WHOSE_DATA_YOU_WANT_TO_DELETE = "Enter the id of the developer whose data you want to delete:";
    public static final String ENTER_THE_ID_OF_THE_DEVELOPER_WHOSE_DATA_YOU_WANT_TO_UPDATE = "Enter the id of the developer whose data you want to update:";


    public static int integerScanner() {
        int receivedFigure;
        Scanner scanner = new Scanner(System.in);
        receivedFigure = scanner.nextInt();
        return receivedFigure;
    }

    public static String stringScanner() {
        String receivedString;
        Scanner scanner = new Scanner(System.in);
        receivedString = scanner.next();
        return receivedString;
    }

    public static void viewMainMenu() {
        System.out.println();
        System.out.println("You are in the main menu.\n" +
                "Select an action number.");
        System.out.println("1.  Add a new Developer.");
        System.out.println("2.  Get view Developer by id.");
        System.out.println("3.  Remove Developer by id.");
        System.out.println("4.  Update developer by id.");
        System.out.println("5.  Exit the program.");
    }
}
