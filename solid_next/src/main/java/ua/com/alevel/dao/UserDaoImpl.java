package ua.com.alevel.dao;

import ua.com.alevel.config.annotation.Service;
import ua.com.alevel.entity.User;
import ua.com.alevel.util.ResourceUtil;

import java.sql.*;
import java.util.Map;

@Service
public class UserDaoImpl implements UserDao {

    private Connection connection;
    private Statement statement;

    private static final String CREATE_USER = "insert into users values(default,?,?)";

    public UserDaoImpl() {
        Map<String, String> dbProperties = ResourceUtil.getResource("db.properties");
        dbProperties.forEach((k,v) -> {
            System.out.println("k = " + k);
            System.out.println("v = " + v);
        });
        try {
            Class.forName(dbProperties.get("db.driver"));
            this.connection = DriverManager.getConnection(
                    dbProperties.get("db.url"),
                    dbProperties.get("db.user"),
                    dbProperties.get("db.password")
            );
            this.statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(User user) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(CREATE_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
