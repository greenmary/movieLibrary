package org.example.handlers;

import org.example.models.Actor;

import java.util.Scanner;

public class UserInputHandlers {
    static Scanner scan = new Scanner(System.in);

    private static int getIntegerFromUser() {
        while (!scan.hasNextInt()) {
            scan.nextLine();
            System.out.println("It is not integer. Try again");
        }
        return scan.nextInt();
    }

    private static int getSelectedOptionFromUser() {
        int result = getIntegerFromUser();
        scan.nextLine();
        if (result > 0 && result < MenuOptions.values().length + 1) {
            return result;
        } else {
            System.out.println("You selected not existing option. Try again.");
            return getSelectedOptionFromUser();
        }
    }
    public static MenuOptions getMenuOptions() {
        return MenuOptions.values()[getSelectedOptionFromUser()-1];
    }

    public static Actor getActorFromUser() {
        System.out.println("Type an actor: ");
        String[] actors = scan.nextLine().split(" ");
        return new Actor(actors[0], actors[1]);
    }
}
