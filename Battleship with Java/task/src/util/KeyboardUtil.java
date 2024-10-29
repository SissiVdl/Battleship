package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KeyboardUtil {
    private static final Scanner KEYBOARD = new Scanner(System.in);

    public static String getInput() {
        return KEYBOARD.nextLine();
    }

    public static String getInput(String message){
        System.out.println(message);
        return getInput();
    }
}

