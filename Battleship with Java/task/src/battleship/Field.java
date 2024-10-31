package battleship;

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
                parts[i] = firstCoordinate.charAt(0) + (Integer.parseInt(firstCoordNumber) + i) + "";
            }
        }
        return parts;
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

