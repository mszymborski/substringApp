package pl.substringapp.substringapp.model;

//TODO Needs Refactor, to be more expandable, less modifiable
public class AppArguments {

    private AppArgument input;
    private AppArgument pattern;

    public AppArguments(String input, String pattern){
        this.input = new AppArgument(input);
        this.pattern = new AppArgument(pattern);
    }

    public AppArgument getInput() {
        return input;
    }

    public AppArgument getPattern() {
        return pattern;
    }
}
