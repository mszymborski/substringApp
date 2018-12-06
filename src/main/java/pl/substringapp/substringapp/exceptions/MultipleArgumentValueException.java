package pl.substringapp.substringapp.exceptions;

import pl.substringapp.substringapp.constants.MessagesConstants;

public class MultipleArgumentValueException extends Exception {

    public MultipleArgumentValueException(String name) {
        super(MessagesConstants.TO_MANY_VALUES_FOR_ARGUMENT + name);
    }
}
