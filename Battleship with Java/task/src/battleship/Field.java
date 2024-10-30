package battleship;

public class Field {
    private final char[][] fieldLayout;

    public Field () {
        this.fieldLayout = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                fieldLayout[i][j] = '~';
            }
        }
    }

    public void validateCoordinates (String firstCoordinate, String secondCoordinate, String firstCoordNumber, String secondCoordNumber) {

        if ((firstCoordinate.charAt(0) < 'A' || firstCoordinate.charAt(0) > 'J') || (secondCoordinate.charAt(0) < 'A' || secondCoordinate.charAt(0) > 'J')){
            throw new IllegalArgumentException("Error! Letters must be between A and J");
        }

        if ((Integer.parseInt(firstCoordNumber) < 1 || Integer.parseInt(firstCoordNumber) > 10) || (Integer.parseInt(secondCoordNumber) < 1 || Integer.parseInt(secondCoordNumber) > 10)){
            throw new IllegalArgumentException("Error! Numbers must be between 1 and 10");
        }

        if ((firstCoordinate.charAt(0) != secondCoordinate.charAt(0)) && (Integer.parseInt(firstCoordNumber) != Integer.parseInt(secondCoordNumber))){
            throw new IllegalArgumentException("Error! Coordinates must be in same line or row");
        }
    }

    public int calculateLength(String firstCoordinate, String secondCoordinate, String firstCoordNumber, String secondCoordNumber) {
        if (firstCoordinate.charAt(0) != secondCoordinate.charAt(0)) {
            return Math.abs((secondCoordinate.charAt(0) - firstCoordinate.charAt(0))) + 1;
        } else {
            return Math.abs((Integer.parseInt(secondCoordNumber) - Integer.parseInt(firstCoordNumber))) + 1;
        }
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

