package battleship;

import java.util.Arrays;

public class Field {
    private final char[][] fieldLayout  = new char[10][10];

    public Field () {
        createField();
    }

    private void createField() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                fieldLayout[i][j] = '~';
            }
        }
    }

    public int calculateLength(String firstCoordinate, String secondCoordinate, String firstCoordNumber, String secondCoordNumber) {
        if (firstCoordinate.charAt(0) != secondCoordinate.charAt(0)) {
            return Math.abs((secondCoordinate.charAt(0) - firstCoordinate.charAt(0))) + 1;
        } else {
            return Math.abs((Integer.parseInt(secondCoordNumber) - Integer.parseInt(firstCoordNumber))) + 1;
        }
    }

    public String[] determineParts(String firstCoordinate, String secondCoordinate, String firstCoordNumber, String secondCoordNumber) {
        String[] parts = new String[calculateLength(firstCoordinate, secondCoordinate, firstCoordNumber, secondCoordNumber)];
        if (firstCoordinate.charAt(0) != secondCoordinate.charAt(0)) {
            for (int i = 0; i < parts.length; i++) {
                parts[i] = (char)(firstCoordinate.charAt(0) + i) + firstCoordNumber;
            }
        } else {
            for (int i = 0; i < parts.length; i++) {
                parts[i] = firstCoordinate.charAt(0) + String.valueOf(Integer.parseInt(firstCoordNumber) + i);
            }
        }
        return parts;
    }

    public void placeShip(String firstCoordinate, String secondCoordinate, String firstCoordNumber, String secondCoordNumber) {
        String[] parts = determineParts(firstCoordinate, secondCoordinate, firstCoordNumber, secondCoordNumber);
        System.out.println(Arrays.toString(parts));

        if (isTooClose(parts)) {
            throw new IllegalArgumentException("Error! You placed it too close to another one. Try again:");
        } else {
            for (String part : parts) {
                fieldLayout[part.charAt(0) - 'A'][Integer.parseInt(part.substring(1)) - 1] = 'O';
            }
        }
    }

    private boolean isTooClose(String[] parts) {
        for (String part : parts) {
            int row = part.charAt(0) - 'A';
            int col = Integer.parseInt(part.substring(1)) - 1;

            if (fieldLayout[row][col] == 'O') {
                return true;
            }
            if (row > 0 && fieldLayout[row - 1][col] == 'O') {
                return true;
            }
            if (row < 9 && fieldLayout[row + 1][col] == 'O') {
                return true;
            }
            if (col > 0 && fieldLayout[row][col - 1] == 'O') {
                return true;
            }
            if (col < 9 && fieldLayout[row][col + 1] == 'O') {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(" ");
        for (int i = 1; i <= 10; i++) {
            builder.append(" ");
            builder.append(i);
        }
        builder.append("\n");

        for (int i = 0; i < 10; i++) {
            builder.append((char)('A' + i));
            for (int j = 0; j < 10; j++) {
                builder.append(" " + fieldLayout[i][j]);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

}

