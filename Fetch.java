import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetch {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/thenu";
        String USER = "root";
        String PASSWORD = "Then1705";

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            // Read Operation
            String selectSQL = "SELECT * FROM Person";
            Statement selectStatement = con.createStatement();
            ResultSet resultSet = selectStatement.executeQuery(selectSQL);

            System.out.println("Read operation results:");
            while (resultSet.next()) {
                // Corrected column names to match your table schema
                System.out.println("ID: " + resultSet.getInt("RenewalId") 
                    + ", First Name: " + resultSet.getString("F_Name") 
                    + ", Last Name: " + resultSet.getString("L_Name") 
                    + ", Email: " + resultSet.getString("Email") 
                    + ", Renewal Date: " + resultSet.getDate("renewal_date"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
