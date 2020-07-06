package validators;

public class MismatchedPasswordValidator {

    public boolean comparePassword(String firstPassword, String secondPassword){

        boolean isMismatched = false;

        if(!firstPassword.equals(secondPassword)){
            isMismatched = true;
        }

        return isMismatched;
    }

}
