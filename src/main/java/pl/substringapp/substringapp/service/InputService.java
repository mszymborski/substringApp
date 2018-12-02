package pl.substringapp.substringapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import pl.substringapp.substringapp.exceptions.ArgumentMissingException;
import pl.substringapp.substringapp.exceptions.MultipleArgumentValueException;
import pl.substringapp.substringapp.model.AppArguments;
import pl.substringapp.substringapp.constants.MessagesConstants;
import pl.substringapp.substringapp.utils.interfaces.ArgumentUtil;
import pl.substringapp.substringapp.utils.interfaces.StringUtil;
import pl.substringapp.substringapp.validator.interfaces.ArgumentValidator;

@Component
public class InputService {

    private static final Logger logger = LoggerFactory.getLogger(InputService.class);

    private ArgumentUtil argumentUtil;
    private StringUtil stringUtil;
    private ArgumentValidator argumentValidator;

    public InputService(ArgumentUtil argumentUtil, StringUtil stringUtil, ArgumentValidator argumentValidator) {
        this.argumentUtil = argumentUtil;
        this.stringUtil = stringUtil;
        this.argumentValidator = argumentValidator;
    }

    public void processInputs(ApplicationArguments args) {
        try {
            AppArguments appArguments = argumentUtil.parseArguments(args);
            if (argumentValidator.validate(appArguments.getInput(), appArguments.getPattern())){
                if(stringUtil.contains(appArguments.getInput(), appArguments.getPattern())){
                    System.out.println(MessagesConstants.PATTERN_IS_A_SUBSTRING_OF_INPUT);
                } else {
                    System.out.println(MessagesConstants.PATTERN_IS_NOT_A_SUBSTRING_OF_INPUT);
                }
                System.exit(0);
            }
            else {
                System.exit(1);
            }

        } catch (MultipleArgumentValueException | ArgumentMissingException e) {
            System.out.print(e.getMessage());
            System.exit(1);
        }

    }
}
