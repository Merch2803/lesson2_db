import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Autho implements Service<Box> {


    @Override
    public void update(Box object) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getInstance();
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET login = ? WHERE id = ?");
            statement.setString(1, object.getLogin());
            statement.setString(2, object.getPassword());
            statement.setInt(1, object.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("Wrong");
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean add(Box object) {
        Connection connection = null;
        List<Box> boxes = new ArrayList<>();
        try {
            connection = ConnectionFactory.getInstance();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (login, password) VALUES (?, ?)");
            statement.setString(1, object.getLogin());
            statement.setString(2, object.getPassword());
            return statement.execute();
        } catch (SQLException throwables) {
            throw new RuntimeException("Wrong");
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
