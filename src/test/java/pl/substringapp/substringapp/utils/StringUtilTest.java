package pl.substringapp.substringapp.utils;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.substringapp.substringapp.model.AppArgument;
import pl.substringapp.substringapp.utils.interfaces.StringUtil;

@RunWith(JUnitParamsRunner.class)
public class StringUtilTest {


    private StringUtil stringUtil = new StringUtilImpl();


    @Test
    @Parameters(method = "prepareContainsTestPositiveParams")
    public void containsTestPositive(String inputString, String patternString){

        Assert.assertTrue(containsTest(inputString, patternString));
    }

    @Test
    @Parameters(method = "prepareContainsTestNegativeParams")
    public void containsTestNegative(String inputString, String patternString){
        Assert.assertFalse(containsTest(inputString, patternString));
    }

    private boolean containsTest(String inputString, String patternString){
        AppArgument input = new AppArgument(inputString);
        AppArgument pattern = new AppArgument(patternString);
        return stringUtil.contains(input, pattern);
    }

    private Object[] prepareContainsTestNegativeParams(){
        return new Object[]{
                new Object[]{"\\\\abcde*sdaf\\\\*s", "\\\\a*\\\\*sda"},
                new Object[]{"abcdefgh","fghj"}
        };
    }

    private Object[] prepareContainsTestPositiveParams(){
        String input = "abcdefghijklmnpqrstuvwxyz*1234567890";
        String input2 = "pofpofpofpofdpfof";
        return new Object[]{
                new Object[]{input, "jklmn"},
                new Object[]{input, "456"},
                new Object[]{input, "yz\\*12"},
                new Object[]{input, "cd*12"},
                new Object[]{input, "ab*wx*34"},
                new Object[]{input, "*xy"},
                new Object[]{input, "xy*"},
                new Object[]{input, "x*y"},
                new Object[]{input, "xy*"},
                new Object[]{input, "\\*123456"},
                new Object[]{input2, "pofd"},
                new Object[]{" ", " "},
                new Object[]{"\\", "\\"},
                new Object[]{"*", "\\*"},
                new Object[]{"123*45", "1*5"},
        };
    }

}
