package pro.sky.testmok;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DaoUserTest {

    private static User user;
    private static final DaoUser out = mock(DaoUser.class);

    private final String Anton = "Anton";
    private final String Anna = "Anna";
    private final String Oleg = "Oleg";
    private final String Irina = "Irina";
    private final List<User> users = List.of(new User(Anton), new User(Anna), new User(Oleg), new User(Irina));


    @BeforeEach
    void createUser() {
        user = new User(Anton);
    }

    @Test
    void shouldFindUserNameIfExist() {
        when(out.getUserByName(Anton)).thenReturn(user);
        assertEquals(user, out.getUserByName(Anton));
    }

    @Test
    void shouldReturnNullIfUserNotExist() {
        String Anna = "Anna";
        when(out.getUserByName(Anna)).thenReturn(null);
        assertNull(out.getUserByName(Anna));
    }

    @Test
    void findAllUsers() {
        when(out.findAllUsers()).thenReturn(users);
        assertEquals(out.findAllUsers(), users);
    }

}