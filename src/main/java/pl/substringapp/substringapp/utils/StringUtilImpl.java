package pl.substringapp.substringapp.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import pl.substringapp.substringapp.model.AppArgument;
import pl.substringapp.substringapp.utils.interfaces.StringUtil;

import java.util.LinkedList;
import java.util.List;

@Component
public class StringUtilImpl implements StringUtil {

    @Override
    public boolean contains(AppArgument inputArgument, AppArgument patternArgument){
        int inputLength = inputArgument.getArgument().length();
        int patternsIterator = 0;
        int inputIterator = 0;
        List<String> patternList = splitPattern(patternArgument.getArgument());
        while (patternsIterator < patternList.size()){
            String pattern = patternList.get(patternsIterator);
            inputIterator = findFirstCharOccurrence(pattern.charAt(0), inputArgument.getArgument(), inputIterator);
            if(inputIterator >= inputLength){
                return false;
            }
            if(checkPattern(inputArgument, inputIterator, pattern)){
                ++patternsIterator;
                inputIterator += pattern.length();
            } else {
                ++inputIterator;
            }
            if(inputIterator >= inputLength){
                return false;
            }
        }
        return true;

    }

    public List<String> splitPattern(String pattern){
        List<String> patternList = new LinkedList<>();
        int i = 0;
        while (i < pattern.length()){
            StringBuilder patternItem = new StringBuilder();
            i = iteratePattern(i ,pattern, patternItem);
            if(!StringUtils.isEmpty(patternItem.toString())){
                patternList.add(patternItem.toString());
            }
        }

        return patternList;
    }

    public int trimAsterisk(String pattern, int iterator){
        for(; iterator < pattern.length(); iterator++){
            if (pattern.charAt(iterator) != '*'){
                return iterator;
            }
        }
        return iterator;
    }

    private boolean checkPattern(AppArgument inputArgument, int inputIterator, String pattern) {
        for(int j=1; j<pattern.length(); j++){
            if(inputArgument.getArgument().charAt(inputIterator + j) != pattern.charAt(j)){
                return false;
            }
        }
        return true;
    }

    private int findFirstCharOccurrence(char pattern, String input, int inputIterator){
        for( ; inputIterator < input.length() ; inputIterator++){
            if(input.charAt(inputIterator) == pattern){
                return inputIterator;
            }
        }
        return inputIterator;
    }


    private int iteratePattern(int iterator, String pattern, StringBuilder patternItem) {
        for (; iterator < pattern.length() ; iterator++){
            char p = pattern.charAt(iterator);
            switch (p){
                case '*':
                    return trimAsterisk(pattern, iterator);
                case '\\':
                    if (iterator + 1 < pattern.length()){
                        if(pattern.charAt(iterator + 1) == '*' || pattern.charAt(iterator + 1) == '\\'){
                            patternItem.append(pattern.charAt(iterator + 1));
                            ++iterator;
                            break;
                        }
                    }
                default:
                    patternItem.append(pattern.charAt(iterator));
                    break;
            }
        }
        return iterator;
    }

}
