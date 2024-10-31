package battleship;

import util.KeyboardUtil;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Field field = new Field();
        System.out.println(field);

        Ship aircraftCarrier = new Ship(5, "Aircraft Carrier");
        Ship battleship = new Ship(4, "Battleship");
        Ship submarine = new Ship(3, "Submarine");
        Ship cruiser = new Ship(3, "Cruiser");
        Ship destroyer = new Ship(2, "Destroyer");


        Ship[] allShips = {aircraftCarrier, battleship, submarine, cruiser, destroyer};

        for (Ship allShip : allShips) {

            boolean shipNotPlaced = true;

            while (shipNotPlaced) {

                String input = KeyboardUtil.getInput("Enter the coördinates of the " + allShip.getName() + " (" + allShip.getSize() + " cells):");

                Coordinates coordinates = new Coordinates(input);

                try {
                    coordinates.validateCoordinates();
                    field.placeShip(coordinates.getFirstCoordinate(), coordinates.getSecondCoordinate(), coordinates.getFirstCoordNumber(), coordinates.getSecondCoordNumber(), allShip.getSize(), allShip.getName());
                    System.out.println(field);
                    shipNotPlaced = false;
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
            }
        }
    }
}




