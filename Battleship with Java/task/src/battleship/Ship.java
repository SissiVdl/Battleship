package battleship;

public class Ship {

    private final int size;
    private final String name;
    private final char symbol;

    public Ship(int size, String name, char symbol) {
        this.size = size;
        this.name = name;
        this.symbol = symbol;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

}