package battleship;

import util.KeyboardUtil;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        Field field = new Field();
        System.out.println(field);

        String Input = KeyboardUtil.getMultipleInputs("Enter the coördinates of the ship:", 3).toString();
        System.out.println(Input);
    }
}
