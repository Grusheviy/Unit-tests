package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.third.tdd.User;
import seminars.third.tdd.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;
    User admin;
    UserRepository userRepository;


    @BeforeEach
    void setUp() {
        user = new User("User","password",false);
        admin = new User("Admin","password", true);
        userRepository = new UserRepository();
    }

    @Test
    void PositiveUserlogIn() {
        assertTrue(user.logIn("User", "password"));
    }
    @Test
    void NegativeUserlogIn() {
        assertFalse(user.logIn("Ivan", "password"));
    }
    @Test
    void PositiveadminlogIn() {
        assertTrue(admin.logIn("Admin", "password"));
    }
    @Test
    void NegativeadminlogIn() {
        assertFalse(admin.logIn("IvanAdmin", "password"));
    }
    @Test
    void PositivDataForUserRepository() {
        user.logIn("User", "password");
        userRepository.addUser(user);
        assertTrue(userRepository.findByName("User"));
    }
    @Test
    void PositivDataForAdminRepository() {
        admin.logIn("Admin", "password");
        userRepository.addUser(admin);
        assertTrue(userRepository.findByName("Admin"));
    }
    @Test
    void NegativeDataForUserRepository() {
        admin.logIn("Ivan", "password");
        userRepository.addUser(admin);
        assertFalse(userRepository.findByName("Admin"));
    }
    @Test
    void NegativeDataForAdminRepository() {
        admin.logIn("IvanAdmin", "password");
        userRepository.addUser(admin);
        assertFalse(userRepository.findByName("IvanAdmin"));
    }
    //    HW_3 проверки функции которая разлогинивает всех пользователей, кроме администраторов
    @Test
    void userlogOut() {
        assertTrue(user.logOut("User", "password", false));
    }
    @Test
    void adminlogOut() {
        assertFalse(user.logOut("User", "password", true));
    }
    @Test
    void PositivDataRemoveForUserRepository() {
        user.logOut("User", "password", false);
        userRepository.removeUser(user);
        assertFalse(userRepository.findByName("User"));
    }
    @Test
    void PositivDataRemoveForAdminRepository() {
        admin.logOut("Admin", "password", true);
        userRepository.removeUser(admin);
        assertTrue(admin.isAuthenticate); // Проверяем, что админ остается залогиненным
        assertTrue(userRepository.findByName("Admin"));
    }
}