package dmitrii.dao;

import dmitrii.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UsersDaoJdbcImpl implements UsersDao {

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM user_tes";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM user_tes WHERE id = ?";

    //language=SQL
    private final String SQL_SELECT_BY_NAME = "SELECT * FROM user_tes WHERE first_name = ?";

    //language=SQL
    private final String SQL_SELECT_INSERT = "INSERT INTO user_tes (first_name, adress) VALUES ( ?, ?)";

    //language=SQL
    private final String SQL_SELECT_UPDATE = "UPDATE user_tes SET first_name=?, adress=? WHERE id=?";

    //language=SQL
    private final String SQL_SELECT_DELETE = "DELETE FROM user_tes WHERE id=?";

    private Connection connection;

    public UsersDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> findAllByFirstName(String firstName) {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_NAME);
            statement.setString(1, firstName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("first_name");
                String adress = resultSet.getString("adress");
                users.add(new User(name, adress));
            }
            return users;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    @Override
    public Optional<User> find(Integer id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String adress = resultSet.getString("adress");
                return Optional.of(new User(firstName, adress));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void save(User user) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SQL_SELECT_INSERT);

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getAdress());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(User user) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SQL_SELECT_UPDATE);

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getAdress());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_DELETE);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        try {
            List<User> users = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String adress = resultSet.getString("adress");
                User user = new User(firstName, adress);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
