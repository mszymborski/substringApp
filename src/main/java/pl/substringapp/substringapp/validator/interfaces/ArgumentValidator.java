package pl.substringapp.substringapp.validator.interfaces;

import pl.substringapp.substringapp.model.AppArgument;

import java.util.List;

public interface ArgumentValidator {
    boolean validate(AppArgument input, AppArgument pattern);
}
