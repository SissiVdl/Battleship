package battleship;

import util.KeyboardUtil;

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
        // Determine length of ship
        System.out.println("Length:" + field.calculateLength(coordinates.getFirstCoordinate(), coordinates.getSecondCoordinate(), coordinates.getFirstCoordNumber(), coordinates.getSecondCoordNumber()));
        // Determine parts of ship
        System.out.println("Parts: " + field.determineParts(coordinates.getFirstCoordinate(), coordinates.getSecondCoordinate(), coordinates.getFirstCoordNumber(), coordinates.getSecondCoordNumber()));
    }
}


