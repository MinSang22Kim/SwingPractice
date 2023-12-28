package Customer_App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Customer {
	public static ArrayList<String> getCustomers() {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("Select name, phone, gender FROM customer");
			ResultSet results = statement.executeQuery();
			ArrayList<String> list = new ArrayList<String>();
			while (results.next()) {
				list.add("Name: " + results.getString("name") + " Phone: " + results.getString("phone") + " Gender: "
						+ results.getString("gender"));
			}
			System.out.println("The data has been fetched");
			return list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// 학생 정보 저장
	public static void createCustomer(String name, String phone, String gender, String age, String note) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con
					.prepareStatement("" + "INSERT INTO customer " + "(name, phone, gender, age, note) " + "VALUE "
							+ "('" + name + "','" + phone + "','" + gender + "','" + age + "','" + note + "')");
			insert.executeUpdate();
			System.out.println("The data has been saved!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 테이블 만들기(mysql 사용)
	public static void createTable() {
		try {
			Connection con = getConnection();
			PreparedStatement createTable = con.prepareStatement("CREATE TABLE IF NOT EXISTS "
					+ "customer(id int NOT NULL AUTO_INCREMENT," + "name varChar(255)," + "phone varChar(255),"
					+ "gender varChar(255)," + "age varChar(255)," + "note varChar(255)," + "PRIMARY KEY(id))");
			createTable.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Table successfully created");
		}
	}

	// sql 서버연결 메소드
	public static Connection getConnection() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://sql5.freemysqlhosting.net:3306/sql5661047";
			String user = "sql5661047";
			String pw = "pIM1Kpt1Bq";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, pw);
			System.out.println("The Connection Successful");
			return con;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static void main(String[] args) {
		createTable();
		createCustomer("MS", "01074181115", "Male", "24", "hi");
		ArrayList<String> list = getCustomers();
		for (String user : list) {
			System.out.println(user);
		}
	}

}
