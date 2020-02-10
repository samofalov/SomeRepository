import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class MySQLInsertExample {

	public static void main(String[] args) {
		// Diena x - 1
		try {
			Properties props = new Properties();
			FileInputStream in = new FileInputStream("db.properties");
			

			props.load(in);
			
			Connection c = DriverManager.getConnection(
					props.getProperty("url"), 
					props.getProperty("username"), 
					props.getProperty("password"));
			
			
			String lastName = "Peterson";
			String firstName = "John";
			String extension = "x0001";
			String email = "john.peterson@gmail.com";
			String jobTitle = "Producer";
			
			String sql = "INSERT INTO employees "
						+"VALUES (1804, ?, ?, ?, ?, 1, NULL, '" + jobTitle + "')";
			
			// These are my customer changes for review
			
			PreparedStatement s = c.prepareStatement(sql);

			s.setString(1, lastName);
			s.setString(2, firstName);
			s.setString(3, extension);
			s.setString(4, email);
			s.setString(5, jobTitle);
			
			s.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
