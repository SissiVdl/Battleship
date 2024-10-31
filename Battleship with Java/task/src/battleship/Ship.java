package battleship;

public class Ship {

    private final int size;
    private final String name;

    public Ship(int size, String name) {
        this.size = size;
        this.name = name;
    }

    public int getSize() {

        return size;
    }

    public String getName() {

        return name;
    }

}