package com.example.bultacocatalogo.DB;
import com.example.bultacocatalogo.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;
import java.util.ArrayList;

public class UserDB {

    public static final String SCHEMA_NAME = "bultaco";
    public static final String CONNECTION ="jdbc:mysql://localhost:3306/bultaco?useSSL=false&serverTimezone=UTC";
    public static final String USER_CONNECTION = "root";
    public static final String PASS_CONNECTION = "Us.4227el";

    private Connection conexion;

    public void conectar() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexion = DriverManager.getConnection(CONNECTION, USER_CONNECTION, PASS_CONNECTION);
    }

    public User getUserByEmail(String email) throws SQLException {
        String select = "SELECT * FROM users WHERE email = ?";
        User user = null;

        try (PreparedStatement ps = conexion.prepareStatement(select)) {
            ps.setString(1, email);
            System.out.println(ps.toString());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new User(
                            rs.getString("name"),
                            rs.getString("username"),
                            rs.getString("email"),
                            rs.getString("password")
                    );
                }
            }
        }
        return user;
    }

    public ArrayList<User> getAllUsers() throws SQLException {
        ArrayList<User> userList = new ArrayList<>();

        try (Statement st = conexion.createStatement()) {
            try (ResultSet rs = st.executeQuery("SELECT * FROM users")) {
                while (rs.next()) {
                    User user = new User(
                            rs.getString("name"),
                            rs.getString("username"),
                            rs.getString("email"),
                            rs.getString("password")
                    );
                    userList.add(user);
                }
            }
        }
        return userList;
    }

    public void insertNewUser(User user) throws SQLException {
        String insert = "INSERT INTO users (name, username, email, password) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(insert)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.executeUpdate();
        }
    }

    public void updateUser(User user) throws SQLException {
        String update = "UPDATE users SET name = ?, username = ?, password = ? WHERE email = ?";

        try (PreparedStatement ps = conexion.prepareStatement(update)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail()); // Se usa 'email' como identificador único
            ps.executeUpdate();
        }
    }

    public void deleteUser(String email) throws SQLException {
        String delete = "DELETE FROM users WHERE email = ?";

        try (PreparedStatement ps = conexion.prepareStatement(delete)) {
            ps.setString(1, email);
            ps.executeUpdate();
        }
    }

    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
}
