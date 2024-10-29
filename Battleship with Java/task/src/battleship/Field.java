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

