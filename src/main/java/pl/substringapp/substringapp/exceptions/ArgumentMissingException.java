package pl.substringapp.substringapp.exceptions;

import pl.substringapp.substringapp.constants.MessagesConstants;

public class ArgumentMissingException extends Throwable {

    public ArgumentMissingException(String name) {
        super(MessagesConstants.MISSING_ARGUMENT + name);
    }
}
