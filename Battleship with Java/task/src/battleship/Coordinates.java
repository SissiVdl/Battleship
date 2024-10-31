package battleship;

public class Coordinates {

    private final String coordinates;
    public Coordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public void validateCoordinates () {
        splitCoordinates();
        sortCoordinates();
        if ((sortCoordinates()[0].charAt(0) < 'A' || sortCoordinates()[0].charAt(0) > 'J') || (sortCoordinates()[1].charAt(0) < 'A' || sortCoordinates()[1].charAt(0) > 'J')){
            throw new IllegalArgumentException("Error! Letters must be between A and J");
        }
        if ((Integer.parseInt(sortCoordinates()[0].substring(1)) < 1 || Integer.parseInt(sortCoordinates()[0].substring(1)) > 10) || (Integer.parseInt(sortCoordinates()[1].substring(1)) < 1 || Integer.parseInt(sortCoordinates()[1].substring(1)) > 10)){
            throw new IllegalArgumentException("Error! Numbers must be between 1 and 10");
        }
        if ((sortCoordinates()[0].charAt(0) != sortCoordinates()[1].charAt(0)) && (Integer.parseInt(sortCoordinates()[0].substring(1)) != Integer.parseInt(sortCoordinates()[1].substring(1)))){
            throw new IllegalArgumentException("Error! Coordinates must be in same line or row");
        }
    }

    public String[] splitCoordinates() {
        return coordinates.split(" ");
    }

    public String[] sortCoordinates() {
        String[] splitCoordinates = splitCoordinates();
        if (splitCoordinates[0].charAt(0) > splitCoordinates[1].charAt(0)) {
            String temp = splitCoordinates[0];
            splitCoordinates[0] = splitCoordinates[1];
            splitCoordinates[1] = temp;
        }

        if (Integer.parseInt(splitCoordinates[0].substring(1)) > Integer.parseInt(splitCoordinates[1].substring(1))) {
            String temp = splitCoordinates[0];
            splitCoordinates[0] = splitCoordinates[1];
            splitCoordinates[1] = temp;
        }
        return splitCoordinates;
    }

    public String getFirstCoordinate() {
        return sortCoordinates()[0];
    }

    public String getSecondCoordinate() {
        return sortCoordinates()[1];
    }

    public String getFirstCoordNumber() {
        return getFirstCoordinate().substring(1);
    }

    public String getSecondCoordNumber() {
        return getSecondCoordinate().substring(1);
    }

    public String getCoordinates() {
        return coordinates;
    }
}
