package battleship;

import util.KeyboardUtil;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Field field = new Field();
        System.out.println(field);

        boolean tooCloseToOtherShip = true;
        while (tooCloseToOtherShip) {
        Ship aircraftCarrier = new Ship(5, "Aircraft Carrier", 'A');
        Ship battleship = new Ship(4, "Battleship", 'B');
        Ship submarine = new Ship(3, "Submarine", 'S');
        Ship cruiser = new Ship(3, "Cruiser", 'C');
        Ship destroyer = new Ship(2, "Destroyer", 'D');
        Ship[] allShips = {aircraftCarrier, battleship, submarine, cruiser, destroyer};

            // Get input and keep asking for input until valid input is given
            boolean inValidCoordinates = true;
            Coordinates coordinates = null;

            while (inValidCoordinates) {

                String input = KeyboardUtil.getInput("Enter the coördinates of the ship:");

                coordinates = new Coordinates(input);

                try {
                    coordinates.validateCoordinates();
                    inValidCoordinates = false;
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
            }

            // Try to place the ship on the field
            try {
                field.placeShip(coordinates.getFirstCoordinate(), coordinates.getSecondCoordinate(), coordinates.getFirstCoordNumber(), coordinates.getSecondCoordNumber());
                System.out.println(field);
                tooCloseToOtherShip = false;
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }
}


