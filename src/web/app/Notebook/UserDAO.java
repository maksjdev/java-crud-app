package web.app.Notebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	 private String jdbcURL;
	    private String jdbcUsername;
	    private String jdbcPassword;
	    private Connection jdbcConnection;
	     
	    public UserDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
	        this.jdbcURL = jdbcURL +
	                "?verifyServerCertificate=false"+
	                "&useSSL=false"+
	                "&requireSSL=false"+
	                "&useLegacyDatetimeCode=false"+
	                "&amp"+
	                "&serverTimezone=UTC";;
	        this.jdbcUsername = "root";
	        this.jdbcPassword = "root";
	    }
	     
	    protected void connect() throws SQLException {
	        if (jdbcConnection == null || jdbcConnection.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver");
	            } catch (ClassNotFoundException e) {
	                throw new SQLException(e);
	            }
	            jdbcConnection = DriverManager.getConnection(
	                                        jdbcURL, jdbcUsername, jdbcPassword);
	        }
	    }
	     
	    protected void disconnect() throws SQLException {
	        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
	            jdbcConnection.close();
	        }
	    }
	     
	    public boolean insertUser(User user) throws SQLException {
	        String sql = "INSERT INTO users (surname, name, age, gender, phone_number) VALUES (?, ?, ?, ?, ?)";
	        connect();
	         
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setString(1, user.getSurname());
	        statement.setString(2, user.getName());
	        statement.setInt(3, user.getAge());
	        statement.setString(4, user.getGender());
	        statement.setString(5, user.getPhone_number());
	        boolean rowInserted = statement.executeUpdate() > 0;
	        statement.close();
	        disconnect();
	        return rowInserted;
	    }
	     
	    public List<User> listAllUsers() throws SQLException {
	        List<User> listUser = new ArrayList<>();
	         
	        String sql = "SELECT * FROM users";
	         
	        connect();
	         
	        Statement statement = jdbcConnection.createStatement();
	        ResultSet resultSet = statement.executeQuery(sql);
	         
	        while (resultSet.next()) {
	            int id = resultSet.getInt("user_id");
	            String surname = resultSet.getString("surname");
	            String name = resultSet.getString("name");
	            int age = resultSet.getInt("age");
	            String gender = resultSet.getString("gender");
	            String phone_number = resultSet.getString("phone_number");
	            
	            User user = new User(id, surname, name, age, gender, phone_number);
	            listUser.add(user);
	        }
	         
	        resultSet.close();
	        statement.close();
	         
	        disconnect();
	         
	        return listUser;
	    }
	    
	   
	    public boolean deleteUser(User user) throws SQLException {
	        String sql = "DELETE FROM users where user_id = ?";
	         
	        connect();
	         
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setInt(1, user.getId());
	         
	        boolean rowDeleted = statement.executeUpdate() > 0;
	        statement.close();
	        disconnect();
	        return rowDeleted;     
	    }
	     
	    public boolean updateUser(User user) throws SQLException {
	        String sql = "UPDATE users SET surname = ?, name = ?, age = ?, gender = ?, phone_number = ?";
	        sql += " WHERE user_id = ?";
	        connect();
	         
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setString(1, user.getSurname());
	        statement.setString(2, user.getName());
	        statement.setInt(3, user.getAge());
	        statement.setString(4, user.getGender());
	        statement.setString(6, user.getPhone_number());
	        statement.setInt(5, user.getId());
	         
	        boolean rowUpdated = statement.executeUpdate() > 0;
	        statement.close();
	        disconnect();
	        return rowUpdated;     
	    }
	     
	    public User getUser(int id) throws SQLException {
	        User user = null;
	        String sql = "SELECT * FROM users WHERE user_id = ?";
	         
	        connect();
	         
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setInt(1, id);
	         
	        ResultSet resultSet = statement.executeQuery();
	         
	        if (resultSet.next()) {
	            String surname = resultSet.getString("surname");
	            String name = resultSet.getString("name");
	            int age = resultSet.getInt("age");
	            String gender = resultSet.getString("gender");
	            String phone_number = resultSet.getString("phone_number");
	             
	            user = new User(id, surname, name, age, gender, phone_number);
	        }
	         
	        resultSet.close();
	        statement.close();
	         
	        return user;
	    }
}
