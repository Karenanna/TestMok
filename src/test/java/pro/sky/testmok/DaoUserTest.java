package pro.sky.testmok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DaoUserTest {

    private static String USER_CORRECT_NAME = "Anton";
    private static String USER_INCORRECT_NAME = "Grigoriy";

    private final String Anton = "Anton";
    private final String Anna = "Anna";
    private final String Oleg = "Oleg";
    private final String Irina = "Irina";
    private final List<User> USER_CORRECT_LIST = List.of(new User(Anton), new User(Anna), new User(Oleg),
            new User(Irina));
    private final List<User> USERS_INCORRECT_LIST = List.of(new User("Grigoriy"), new User("Boris"));
    DaoUser daoUser;

    @BeforeEach
    void createUser() {
        daoUser = new DaoUser();
    }

    @Test
    void shouldFindUserNameIfExist() {
        String User = Anton;
        Assertions.assertEquals(User, daoUser.getUserByName("Anton"));
    }

    @Test
    void shouldReturnNullIfUserNotExist() {
        String Anna = "Anna";
        Assertions.assertNull(daoUser.getUserByName(USER_INCORRECT_NAME));
    }

    @Test
    void shouldFindCorrectAllUsers() {
        Assertions.assertEquals(USER_CORRECT_LIST, daoUser.findAllUsers());
    }

    @Test
    void shouldFindIncorrectAllUsers() {
        Assertions.assertNotEquals(USERS_INCORRECT_LIST, daoUser.findAllUsers());
    }

}