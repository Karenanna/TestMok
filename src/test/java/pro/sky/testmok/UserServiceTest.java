package pro.sky.testmok;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private final DaoUser daoUserMock = mock(DaoUser.class);
    private UserService out;
    private static User Anton;
    private static User Anna;
    private final String NEW_ANTON = "Anton";
    private final String NEW_ANNA = "Anna";

    @BeforeEach
    public void createNewUser() {
        Anton = new User(NEW_ANTON);
        Anna = new User(NEW_ANNA);
    }

    @BeforeEach
    public void initOut() {
        out = new UserService(daoUserMock);
    }

    @Test
    void shouldFindUser() {
        when(daoUserMock.getUserByName(NEW_ANTON)).thenReturn(Anton);
        assertTrue(out.checkUserExist(Anton));
    }

    @Test
    void shouldReturnNullIfUserNotExist() {
        when(daoUserMock.getUserByName(NEW_ANNA)).thenReturn(null);
        assertFalse(out.checkUserExist(Anna));

    }

}