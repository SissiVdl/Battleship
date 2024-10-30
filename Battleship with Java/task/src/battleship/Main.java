package battleship;

import util.KeyboardUtil;


public class Main {

    public static void main(String[] args) {
        Field field = new Field();
        System.out.println(field);

        boolean noValidInputYet = true;
        while (noValidInputYet) {
         // Get input
            String coordinates = KeyboardUtil.getInput("Enter the coördinates of the ship:");
            String length = KeyboardUtil.getInput();
            String parts = KeyboardUtil.getInput();

        // Split in 2 coordinates
            String[] splitCoordinates = coordinates.split(" ");
            String firstCoordinate = splitCoordinates[0];
            String secondCoordinate = splitCoordinates[1];
        // Get number from coordinates
            String firstCoordNumber = firstCoordinate.substring(1);
            String secondCoordNumber = secondCoordinate.substring(1);

        try {
            System.out.println(field.validateCoordinates(firstCoordinate, secondCoordinate, firstCoordNumber, secondCoordNumber));
            noValidInputYet = false;
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
}

