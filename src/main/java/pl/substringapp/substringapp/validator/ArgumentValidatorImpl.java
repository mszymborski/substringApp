package pl.substringapp.substringapp.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import pl.substringapp.substringapp.model.AppArgument;
import pl.substringapp.substringapp.constants.MessagesConstants;
import pl.substringapp.substringapp.utils.interfaces.StringUtil;
import pl.substringapp.substringapp.validator.interfaces.ArgumentValidator;

import java.util.LinkedList;
import java.util.List;

@Component
public class ArgumentValidatorImpl implements ArgumentValidator {

    private StringUtil stringUtil;

    public ArgumentValidatorImpl(StringUtil stringUtil) {
        this.stringUtil = stringUtil;
    }

    @Override
    public boolean validate(AppArgument input, AppArgument pattern) {
        List<String> messages = new LinkedList<>();
        int patternLength = 0;
        checkArgumentValueEmpty(input, messages, "input");
        if(stringUtil.trimAsterisk(pattern.getArgument(),0) < pattern.getArgument().length()){
            List<String> patternList = stringUtil.splitPattern(pattern.getArgument());
            if(patternList.size() == 0){
                messages.add(MessagesConstants.EMPTY_VALUE_OF_ARGUMENT + "pattern");
            }
            for (String p : patternList){
                patternLength += p.length();
            }
            if(input.getArgument().length() < patternLength){
                messages.add(MessagesConstants.STRING_2_IS_LONGER_THAN_STRING_1);
            }
        }
        if(!messages.isEmpty()){
            System.out.println(MessagesConstants.ARGUMENT_VALIDATION_ERROR + messages);
            return false;
        }
        return true;
    }

    private void checkArgumentValueEmpty(AppArgument argument, List<String> messages, String valueName){
        if (StringUtils.isEmpty(argument.getArgument())){
            messages.add(MessagesConstants.EMPTY_VALUE_OF_ARGUMENT + valueName);
        }
    }

}
