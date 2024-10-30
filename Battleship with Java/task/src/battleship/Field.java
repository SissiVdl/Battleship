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

    public int calculateLength(String firstCoordinate, String secondCoordinate, String firstCoordNumber, String secondCoordNumber) {
        if (firstCoordinate.charAt(0) != secondCoordinate.charAt(0)) {
            return Math.abs((secondCoordinate.charAt(0) - firstCoordinate.charAt(0))) + 1;
        } else {
            return Math.abs((Integer.parseInt(secondCoordNumber) - Integer.parseInt(firstCoordNumber))) + 1;
        }
    }

    public static String determineParts(String firstCoordinate, String secondCoordinate, String firstCoordNumber, String secondCoordNumber) {
        StringBuilder parts = new StringBuilder();

        if (firstCoordinate.charAt(0) == secondCoordinate.charAt(0)) {
            for (int i = Integer.parseInt(firstCoordNumber); i <= Integer.parseInt(secondCoordNumber); i++) {
                parts.append(firstCoordinate.charAt(0)).append(i).append(" ");
            }
        } else {
            for (int i = firstCoordinate.charAt(0); i <= secondCoordinate.charAt(0); i++) {
                parts.append((char) i).append(firstCoordNumber).append(" ");
            }
        }
        return parts.toString();
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

