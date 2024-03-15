package com.von.api.menu;

import com.von.api.enums.Messenger;
import com.von.api.user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private static MenuRepository instance;

    static {
        try {
            instance = new MenuRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MenuRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/vondb",
                "root",
                "rootroot");
        pstmt = null;
        rs = null;
    }

    public static MenuRepository getInstance() {
        return instance;
    }

    public Messenger makeTable() {
        String sql = "CREATE TABLE IF NOT EXISTS menus (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "category VARCHAR(10) NOT NULL," +
                "item VARCHAR(20) NOT NULL)";
        try {
            pstmt = connection.prepareStatement(sql);
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e) {
            System.err.println("SQL Exception Occurred");
            return Messenger.ERROR;
        }
    }

    public Messenger removeTable() {
        String sql = "DROP TABLE IF EXISTS menus";
        try {
            pstmt = connection.prepareStatement(sql);
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e) {
            System.err.println("SQL Exception Occurred");
            return Messenger.ERROR;
        }
    }


    public Messenger insertMenu(Menu menu) {
        String sql = "INSERT INTO menus(category, item) VALUES(?,?)";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, menu.getCategory());
            pstmt.setString(2, menu.getItem());
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e) {
            System.err.println("SQL Exception Occurred :" + menu.getCategory() + " " + menu.getItem());
            return Messenger.ERROR;
        }
    }

    public List<?> getMenusByCategory(String category) {
        String sql = "SELECT m.item FROM menus m WHERE category = ?";
        List<Menu> menus = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, category);
            rs = pstmt.executeQuery();
            while (rs.next()) menus.add(Menu.builder().item(rs.getString(1)).build());
        } catch (SQLException e) {
            System.err.println("SQL Exception Occurred");
            return menus;
        }
        return menus;
    }

    public Messenger returnMessenger() throws SQLException {
        String sql = "";
        pstmt = connection.prepareStatement(sql);
        rs = pstmt.executeQuery();
        Messenger m = null;
        return m;
    }

    public List<?> returnList() throws SQLException {
        String sql = "";
        pstmt = connection.prepareStatement(sql);
        rs = pstmt.executeQuery();
        List<Menu> ls = new ArrayList<>();
        if (rs.next()) {
            do {
                ls.add(Menu.builder()
                        .item(rs.getString("item"))
                        .category(rs.getString("category"))
                        .build());
            } while (rs.next());
        } else {
            System.out.println("No data");
        }
        return ls;
    }
}
