package user;

import java.sql.*;
import java.util.List;

public class UserRepository {
    private Connection connection;
    private static UserRepository instance;

    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private UserRepository() throws SQLException {
         connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/vondb",
                "root",
                "rootroot");
    };
    public static UserRepository getInstance(){return instance;}
    public String test(){
        return "UserRepository 연결";
    }
    public List<?> findUsers() throws SQLException {
        String sql = "select * from board";
        PreparedStatement pstmt  = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()) {
            do {
                System.out.printf("ID : %d\t Title : %S\t Content : %s\t Writer : %s\n",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                System.out.println();
            } while (rs.next());
        }else {
            System.out.println("데이터가 없습니다.");
        }

        rs.close();
        pstmt.close();
        connection.close();

        return null;
    }

    public String mktable() throws SQLException {
        String sql = "SHOW TABLES LIKE 'users';";
        PreparedStatement pstmt  = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            System.out.println("이미 테이블이 존재합니다.");
        }else{String createSql = "CREATE TABLE users (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    username VARCHAR(20) NOT NULL,\n" +
                "    password VARCHAR(20) NOT NULL,\n" +
                "    name VARCHAR(20),\n" +
                "    phone VARCHAR(20),\n" +
                "    job VARCHAR(20),\n" +
                "    height VARCHAR(20),\n" +
                "    weight VARCHAR(20)\n" +
                ");";
            PreparedStatement createStmt = connection.prepareStatement(createSql);
            createStmt.executeUpdate();
            System.out.println("테이블 'users' 생성 완료");
            createStmt.close();
        }

        rs.close();
        pstmt.close();

        return null;
    }

    public String rmtable() throws SQLException {
        String sql = "DROP TABLE users;";
        PreparedStatement pstmt  = connection.prepareStatement(sql);
        pstmt.executeUpdate();
        pstmt.close();

        return null;
    }
}
