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

            // Sort coordinates on letter if needed
            if (splitCoordinates[0].charAt(0) > splitCoordinates[1].charAt(0)) {
                String temp = splitCoordinates[0];
                splitCoordinates[0] = splitCoordinates[1];
                splitCoordinates[1] = temp;
            }

            // sort coordinates on number if needed
            if (Integer.parseInt(splitCoordinates[0].substring(1)) > Integer.parseInt(splitCoordinates[1].substring(1))) {
                String temp = splitCoordinates[0];
                splitCoordinates[0] = splitCoordinates[1];
                splitCoordinates[1] = temp;
            }

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
        System.out.println("Parts: " + field.determineParts(firstCoordinate, secondCoordinate, firstCoordNumber, secondCoordNumber));
    }
}


