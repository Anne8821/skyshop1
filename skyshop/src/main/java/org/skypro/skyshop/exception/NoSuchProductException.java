package org.skypro.skyshop.exception;

public class NoSuchProductException extends RuntimeException {

    public NoSuchProductException() {
        super("Продукт не найден");
    }

    public NoSuchProductException(String message) {
        super(message);
    }
}