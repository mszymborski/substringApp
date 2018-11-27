package pl.substringapp.substringapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import pl.substringapp.substringapp.exceptions.ArgumentMissingException;
import pl.substringapp.substringapp.exceptions.MultipleArgumentValueException;
import pl.substringapp.substringapp.model.AppArguments;
import pl.substringapp.substringapp.utils.ArgumentUtil;

@Component
public class InputService {

    private static final Logger logger = LoggerFactory.getLogger(InputService.class);

    private ArgumentUtil argumentUtil;

    @Autowired
    public InputService(ArgumentUtil argumentUtil) {
        this.argumentUtil = argumentUtil;
    }

    public void processInputs(ApplicationArguments args) {

        try {
            AppArguments appArguments = argumentUtil.parseArguments(args);
        } catch (MultipleArgumentValueException | ArgumentMissingException e) {
            logger.error(e.getMessage());
        }

    }
}
