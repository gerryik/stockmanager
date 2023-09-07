package uk.co.gagbonye.djshopping.stockmanager.exceptions;

public class StockNotFoundException extends Exception {

    public StockNotFoundException() {
    }

    public StockNotFoundException(String message) {
        super(message);
    }

    public StockNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
