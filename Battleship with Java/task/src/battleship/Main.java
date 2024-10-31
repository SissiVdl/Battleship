package battleship;

import util.KeyboardUtil;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Field field = new Field();
        System.out.println(field);

        // Get input and keep asking for input until valid input is given
        boolean noValidInputYet = true;
        Coordinates coordinates = null;

        while (noValidInputYet) {

            // Get and validate input
            String input = KeyboardUtil.getInput("Enter the coördinates of the ship:");

            coordinates = new Coordinates(input);

            try {
                coordinates.validateCoordinates();
                noValidInputYet = false;
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        // System.out.println("Valid input: " + coordinates.getCoordinates());
        // System.out.println("Length:" + field.calculateLength(coordinates.getFirstCoordinate(), coordinates.getSecondCoordinate(), coordinates.getFirstCoordNumber(), coordinates.getSecondCoordNumber()));
        // System.out.println("Parts:" + Arrays.toString(field.determineParts(coordinates.getFirstCoordinate(), coordinates.getSecondCoordinate(), coordinates.getFirstCoordNumber(), coordinates.getSecondCoordNumber())));

        try {
            field.placeShip(coordinates.getFirstCoordinate(), coordinates.getSecondCoordinate(), coordinates.getFirstCoordNumber(), coordinates.getSecondCoordNumber());
            System.out.println(field);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}


