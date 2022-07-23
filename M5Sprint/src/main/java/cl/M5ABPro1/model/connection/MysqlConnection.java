package cl.M5ABPro1.model.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnection {
	
	private static Connection connection;

	private MysqlConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/risk_prev_DB", "risk-prev", "@1g/4c#F2$_m");
		} catch (Exception e) {
			System.out.println("¡Falló la conexión!");
		}
	}
	
	public static Connection getInstance() {
		if (connection == null) {
			new MysqlConnection();
		}
		return connection;
	}
	
	
}
