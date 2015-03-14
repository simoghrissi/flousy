package flousy.user;

/**
 * Created by Samir on 13/03/2015.
 */
public class Validator {

    private Validator() {}

    public static boolean validUser(User user) {
        ValidatorCode codeFirstName = validName(user.getFirstName());
        ValidatorCode codeLastName = validName(user.getLastName());
        ValidatorCode codePhoneNumber = validPhoneNumber(user.getPhoneNumber());
        ValidatorCode codeEmail = validEmail(user.getEmail());
        ValidatorCode codePassword = validPassword(user.getPassword());

        if(codeFirstName == ValidatorCode.OK
                && codeLastName == ValidatorCode.OK
                && codePhoneNumber == ValidatorCode.OK
                && codeEmail == ValidatorCode.OK
                && codePassword == ValidatorCode.OK) {
            return true;
        }

        return false;
    }

    private static ValidatorCode validName(String name) {
        if(name.length() == 0) {
            return ValidatorCode.ERROR_NAME;
        }

        return ValidatorCode.OK;
    }

    private static ValidatorCode validPhoneNumber(String phoneNumber) {
        if(phoneNumber.length() == 0) {
            return ValidatorCode.ERROR_PHONENUMBER;
        }

        return ValidatorCode.OK;
    }

    private static ValidatorCode validEmail(String email) {
        if(email.length() == 0) {
            return ValidatorCode.ERROR_EMAIL;
        }

        return ValidatorCode.OK;
    }

    private static ValidatorCode validPassword(String password) {
        if(password.length() == 0) {
            return ValidatorCode.ERROR_PASSWORD;
        }

        return ValidatorCode.OK;
    }
}
