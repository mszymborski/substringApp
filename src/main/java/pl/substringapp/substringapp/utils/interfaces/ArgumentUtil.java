package pl.substringapp.substringapp.utils.interfaces;

import org.springframework.boot.ApplicationArguments;
import pl.substringapp.substringapp.exceptions.ArgumentMissingException;
import pl.substringapp.substringapp.exceptions.MultipleArgumentValueException;
import pl.substringapp.substringapp.model.AppArguments;

public interface ArgumentUtil {
    AppArguments parseArguments(ApplicationArguments args) throws MultipleArgumentValueException, ArgumentMissingException;
}
