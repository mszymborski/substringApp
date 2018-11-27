package pl.substringapp.substringapp.exceptions;

public class MultipleArgumentValueException extends Throwable {
    public MultipleArgumentValueException(String name) {
        super("To many values for argument " + name);
    }
}
