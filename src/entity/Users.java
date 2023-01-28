package entity;

public class Users {
    private String userName;
    private String firstName;
    private String password;

    public Users() {
    }


    public Users(String userName, String firstName, String password) {
        this.userName = userName;
        this.firstName = firstName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPassword() {
        return password;
    }
}
