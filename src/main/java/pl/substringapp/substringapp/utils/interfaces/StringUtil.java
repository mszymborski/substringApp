package pl.substringapp.substringapp.utils.interfaces;

import pl.substringapp.substringapp.model.AppArgument;

import java.util.List;

public interface StringUtil {
    boolean contains(AppArgument input, AppArgument pattern);
    List<String> splitPattern(String pattern);
    int trimAsterisk(String pattern, int iterator);
}
