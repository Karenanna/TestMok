package pro.sky.testmok;

import java.util.ArrayList;
import java.util.List;

public class DaoUser {

    private final List<User> userList = new ArrayList<>();

    public DaoUser() {
        userList.add(new User("Anton"));
        userList.add(new User("Anna"));
        userList.add(new User("Oleg"));
        userList.add(new User("Irina"));
    }

    public User getUserByName(String name) {
        return userList.stream().filter(o -> o.getName().equals(name)).findFirst().orElse(null);
    }

    public List<User> findAllUsers() {
        return userList;
    }
}
