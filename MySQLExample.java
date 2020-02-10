import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class MySQLExample {

	public static void main(String[] args) {

		try {
			Properties props = new Properties();
			FileInputStream in = new FileInputStream("db.properties");
			
			// Properties set
			
			props.load(in);
			
			Connection c = DriverManager.getConnection(
					props.getProperty("url"), 
					props.getProperty("username"), 
					props.getProperty("password"));
			
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from customers");
			
			while (rs.next()) {
				System.out.println(rs.getInt("CustomerNumber"));
				System.out.println(rs.getString("ContactFirstName"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
