package pl.substringapp.substringapp.model;

public class AppArguments {

    private String input;
    private String pattern;

    public AppArguments(String input, String pattern) {
        this.input = input;
        this.pattern = pattern;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
