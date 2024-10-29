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

    public static List<String> getMultipleInputs(String message, int numberOfLines) {
        System.out.println(message);
        List<String> inputs = new ArrayList<>();
        for (int i = 0; i < numberOfLines; i++) {
            inputs.add(getInput());
        }
        return inputs;
    }
}

