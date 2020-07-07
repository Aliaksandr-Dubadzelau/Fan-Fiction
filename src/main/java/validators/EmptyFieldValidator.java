package validators;

public class EmptyFieldValidator {

    private final static String EMPTY_STRING = "";

    public boolean check(String field){
        return field.equals(EMPTY_STRING);
    }

}
