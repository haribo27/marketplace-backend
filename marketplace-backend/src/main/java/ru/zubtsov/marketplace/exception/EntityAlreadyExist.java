package ru.zubtsov.marketplace.exception;

public class EntityAlreadyExist extends RuntimeException {
    public EntityAlreadyExist(String message) {
        super(message);
    }
}
