package battleship;

import util.KeyboardUtil;


public class Main {

    public static void main(String[] args) {
        Field field = new Field();
        System.out.println(field);


        // Get input and keep asking for input until valid input is given
        boolean noValidInputYet = true;
        while (noValidInputYet) {

            // Get input
            String coordinates = KeyboardUtil.getInput("Enter the coördinates of the ship:");

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

        // Calculate and print length of the ship
        if (firstCoordinate.charAt(0) != secondCoordinate.charAt(0)) {
            System.out.println("Length:" + (Math.abs((secondCoordinate.charAt(0) - firstCoordinate.charAt(0))) + 1));
        } else {
            System.out.println("Length:" + (Math.abs((Integer.parseInt(secondCoordNumber) - Integer.parseInt(firstCoordNumber))) + 1));
        }

    }
}
}


