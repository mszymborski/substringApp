package pl.substringapp.substringapp.utils;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import pl.substringapp.substringapp.exceptions.ArgumentMissingException;
import pl.substringapp.substringapp.model.AppArguments;
import pl.substringapp.substringapp.exceptions.MultipleArgumentValueException;

import java.util.List;
import java.util.Optional;

@Component
public class ArgumentUtil {


    public AppArguments parseArguments(ApplicationArguments args) throws MultipleArgumentValueException, ArgumentMissingException {
        AppArguments applicationArgs = null;
        String input = parseArgument(args, "input");
        String pattern = parseArgument(args, "pattern");
        if(!StringUtils.isEmpty(input) && !StringUtils.isEmpty(pattern)){
            applicationArgs = new AppArguments(input, pattern);
        }
        return applicationArgs;
    }

    private String parseArgument(ApplicationArguments args, String name) throws MultipleArgumentValueException, ArgumentMissingException {
        String argument;
        List<String> options = args.getOptionValues(name);
        if(!options.isEmpty() && options.size() == 1){
            argument = options.get(0);
        } else if(options.size() > 1){
            throw new MultipleArgumentValueException(name);
        } else {
            throw new ArgumentMissingException(name);
        }
        return argument;
    }

}
