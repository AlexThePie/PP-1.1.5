package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import java.sql.SQLException;

public class Main {

    private static final UserService user = new UserServiceImpl();
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        Util util = new Util();
        util.getSessionFactory();
        user.createUsersTable();
        user.saveUser("Alex", "Russkin", (byte) 41);
        user.saveUser("Jackie", "Chan", (byte) 60);
        user.saveUser("Mel", "Gibson", (byte) 61);
        user.saveUser("Hard", "Choices", (byte) 38);
        user.removeUserById(3);
        for (User allUser : user.getAllUsers()) {
            System.out.println(allUser);
        }
        user.cleanUsersTable();
        user.dropUsersTable();
    }
}
