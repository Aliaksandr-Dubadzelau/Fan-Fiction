package validators;

public class EmptyFieldValidator {

    public boolean check(String field){
        return field.equals("");
    }

}
