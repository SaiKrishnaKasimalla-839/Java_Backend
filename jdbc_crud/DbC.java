
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbC{

    private static final String URL =
            "XXXXXXXXXXXXXXXXXXXXXx";

    private static final String USER = "XX";

    private static final String PASSWORD = "XXXXXXXXXXXXXXxxxx";

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(URL, USER, PASSWORD);

    }
}