package battleship;

import util.KeyboardUtil;


public class Main {

    public static void main(String[] args) {
        Field field = new Field();
        System.out.println(field);

        String firstCoordinate = "";
        String secondCoordinate = "";
        String firstCoordNumber = "";
        String secondCoordNumber = "";

        // Get input and keep asking for input until valid input is given
        boolean noValidInputYet = true;
        while (noValidInputYet) {

            // Get input
            String coordinates = KeyboardUtil.getInput("Enter the coördinates of the ship:");

            // Split in 2 coordinates
            String[] splitCoordinates = coordinates.split(" ");
            firstCoordinate = splitCoordinates[0];
            secondCoordinate = splitCoordinates[1];
            // Get number from coordinates
            firstCoordNumber = firstCoordinate.substring(1);
            secondCoordNumber = secondCoordinate.substring(1);

            try {
                field.validateCoordinates(firstCoordinate,secondCoordinate,firstCoordNumber,secondCoordNumber);
                noValidInputYet = false;
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
        System.out.println("Length:" + field.calculateLength(firstCoordinate, secondCoordinate, firstCoordNumber, secondCoordNumber));
        System.out.println("Parts:" + field.determineParts(secondCoordinate,firstCoordNumber,secondCoordNumber));

    }
}

