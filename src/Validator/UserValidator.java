package Validator;

import static console_io.Writer.writeError;

public class UserValidator {
    private static final String USERNAME = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$";
    private static final String PASSWORD = "^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$";
//    Pattern compile = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$");

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


