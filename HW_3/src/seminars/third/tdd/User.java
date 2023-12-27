package seminars.third.tdd;

public class User {

    String name;
    String password;
    private final boolean isAdmin;

    public boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    // Метод для входа в систему
    public boolean logIn(String name, String password) {
        if (name.equals(this.name) && password.equals(this.password)) {
            isAuthenticate = true;
            return true;
        } else {
            return false;
        }
    }
    public boolean logOut(String name, String password, boolean isAdmin) {
        if (name.equals(this.name) && password.equals(this.password) && !isAdmin) {
            isAuthenticate = false;
            return true;
        } else {
            return false;
        }
    }
}