// **********************************************************************************
// Title: NoWinesFoundException
// Author: Autumn Horn
// File: NoWinesFoundException
// Description: Exception for cases where there are no wines in a given wine list
// **********************************************************************************
public class NoWinesFoundException extends Exception {
    private WineList wines = new WineList();

    public NoWinesFoundException(WineList wines) {
        super("No wines found in this array");
        this.wines = wines;
    }

    public WineList getWines() {
        return wines;
    }
}
