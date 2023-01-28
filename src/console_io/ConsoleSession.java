package console_io;

import entity.Users;

public class ConsoleSession {
    private Users currentUser;

    public ConsoleSession(Users currentUser) {
        this.currentUser = currentUser;
    }

    public Users getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Users currentUser) {
        this.currentUser = currentUser;
    }
}