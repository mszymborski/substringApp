package pl.substringapp.substringapp.exceptions;

public class ArgumentMissingException extends Throwable {
    public ArgumentMissingException(String name) {
        super("Missing argument " + name);
    }
}
