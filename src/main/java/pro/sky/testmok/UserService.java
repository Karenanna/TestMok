package pro.sky.testmok;

public class UserService {

    private final DaoUser daoUser;

    public UserService(DaoUser daoUser) {
        this.daoUser = daoUser;
    }

    public boolean checkUserExist(User user) {
        User userByName = daoUser.getUserByName(user.getName());
        return userByName != null;
    }
}
