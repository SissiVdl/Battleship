package battleship;

import util.KeyboardUtil;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        Field field = new Field();
        System.out.println(field);

        String Coordinates = KeyboardUtil.getInput("Enter the coördinates of the ship:");
        String Length = KeyboardUtil.getInput();
        String Parts = KeyboardUtil.getInput();

        System.out.println(Coordinates + "\n" + Length + "\n" + Parts);
    }
}
