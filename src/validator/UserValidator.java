package validator;

import static console.Writer.writeError;

public class UserValidator {
    private static final String USERNAME = "^[a-zA-Z]{4,8}$";
    private static final String PASSWORD = "^[0-9]{8}$";


    public static boolean isValidUsername(String username) {
        if (!username.matches(USERNAME)) {
            writeError(username + " is invalid username");
            return false;
        }
        return true;
    }

    public static boolean isValidPassword(String password) {
        if (!password.matches(PASSWORD)) {
            writeError(password + " is invalid password");
            return false;
        }
        return true;
    }
}


