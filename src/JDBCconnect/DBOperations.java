package JDBCconnect;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.net.URL;
import java.net.URLClassLoader;
import com.Amazon.com.AmazonHomePage;
import com.Amazon.com.SearchResults;
import com.mysql.jdbc.Driver;

public class DBOperations {
	private static WebDriver driver;
	SearchResults sr = PageFactory.initElements(driver, SearchResults.class);
	private static final String db = "jdbc:mysql://localhost:3306/amazon";
	private static final String dbserver = "jdbc:mysql://localhost:3306";
	private static final String user = "root";
	private static final String pwd = "root";

	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;
	private static PreparedStatement pstmt;

	public static void main(String args[]) {
		DBOperations d1 = new DBOperations();
		/*
		 * ClassLoader cl = ClassLoader.getSystemClassLoader(); URL[] urls =
		 * ((URLClassLoader)cl).getURLs(); for(URL url: urls){
		 * System.out.println(url.getFile()); }
		 */

		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter the option number:");
		System.out.println("1. Retrieve data");
		System.out.println("2.Insert a new record");
		System.out.println("3.Update a record");
		System.out.println("4.Create a database");
		System.out.println("5.Delete a database record");
		System.out.println("6.Drop the database created");

		int choice = s1.nextInt();
		s1.nextLine();

		
		switch (choice) {
		case 1:
			d1.retrieveData();
			break;

		case 2:
			//d1.insertRecord(int srno,String);
			break;

		case 3:
			d1.updateRecord();
			break;

		case 4:
			System.out.println("Name of the database you want to create:");
			d1.createDb(s1.nextLine());
			break;

		case 5:
			System.out.println("Name of the database record you want to delete:");

			d1.deleteDb(s1.nextLine());

		case 6:
			System.out.println("Name of the database you want to delete:");
			d1.deleteDb(s1.nextLine());
		}
		s1.close();
	}

	public void retrieveData() {
		String query1 = "Select * from cars_tbl";
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			con = DriverManager.getConnection(db, user, pwd);

			stmt = con.createStatement();
			rs = stmt.executeQuery(query1);
			while (rs.next()) {
				System.out.println("");
				System.out.printf("Car Registration: %s, Car Model: %s, Car Color: %s, Kms run: %d",
						rs.getString("car_regn"), rs.getString("car_model"), rs.getString("car_color"),
						rs.getInt("car_mileage"));
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				con.close();
				stmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

	}

	public void insertRecord(ArrayList<String> Str) {
		String query2 = "Insert into amazon.searchresults_tbl (Sr_no,results_tbl) values (?,?)";
		//Scanner s2 = new Scanner(System.in);
		
		try{

			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			con = DriverManager.getConnection(db, user, pwd);

			pstmt = con.prepareStatement(query2);
			//System.out.println("Enter the search Results:");
			//pstmt.setString(1, s2.nextLine());
			//pstmt.setString(2, s2.nextLine());
			/*System.out.println("Car model:");
			pstmt.setString(2, s2.nextLine());
			System.out.println("Car color:");
			pstmt.setString(3, s2.nextLine());
			System.out.println("Kms run:");
			pstmt.setInt(4, s2.nextInt());*/
			
		
			

			int ret = pstmt.executeUpdate();
			if (ret == 1) {
				System.out.println("Successfully added a new record");
			} else {
				System.out.println("Unable to add a new record");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
				//s2.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public void updateRecord() {

		// Prepared statement
		String query3 = "Update cars_tbl \n" + "SET car_color = ? \n" + "WHERE car_regn = ?";

		Scanner s3 = new Scanner(System.in);

		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			con = DriverManager.getConnection(db, user, pwd);

			pstmt = con.prepareStatement(query3);
			System.out.println("Car regn that you want to update:");
			pstmt.setString(2, s3.nextLine());
			System.out.println("Car color:");
			pstmt.setString(1, s3.nextLine());

			int ret = pstmt.executeUpdate();
			if (ret == 1) {
				System.out.println("Successfully updated the record");
			} else {
				System.out.println("Unable to update the record. Verify regn number.");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
				s3.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public void createDb(String dbname) {

		// Prepared statement
		String query4 = "CREATE DATABASE IF NOT EXISTS " + dbname;

		Scanner s4 = new Scanner(System.in);

		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// e.printStackTrace();
				System.out.println("Hmm..some classes are missing");
			}

			con = DriverManager.getConnection(dbserver, user, pwd);

			pstmt = con.prepareStatement(query4);

			pstmt.executeUpdate();
			System.out.println("Successfully created the database");

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
				s4.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public void deleteDb(String dbname) {

		// Prepared statement
		String query5 = "DROP DATABASE " + dbname;

		Scanner s5 = new Scanner(System.in);

		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			con = DriverManager.getConnection(dbserver, user, pwd);

			ResultSet resultSet = con.getMetaData().getCatalogs();
			
			while (resultSet.next()) {

				  // Get the database name, which is at position 1

				  String databaseName = resultSet.getString(1);

				  if(dbname.equals("library")) {

				  System.out.print("yes");
			pstmt = con.prepareStatement(query5);

			pstmt.executeUpdate();

			System.out.println("Successfully deleted the database");
				  }
		}} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
				s5.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
