package model.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseManager {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/coursejdbc";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "P17965";

	public static void createDatabase(String DB_NAME, String DB_PASSWORD_USER) {

		if (!DB_PASSWORD.equals(DB_PASSWORD_USER)) {
			System.out.println("Sorry. Incorrect password.");
		} else {
			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
					Statement statement = connection.createStatement()) {
				
				boolean create = databaseExists(DB_NAME);
				if (!create) {
					String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;
					int rows = statement.executeUpdate(createDatabaseSQL);
					System.out.println("Database created successfully.");
				}
				else {
					System.out.println("Sorry, but this name already exists");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void deleteDatabase(String DB_NAME, String DB_PASSWORD_USER) {

		if (!DB_PASSWORD.equals(DB_PASSWORD_USER)) {
			System.out.println("Sorry. Incorrect password.");
		} else {
			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
					Statement statement = connection.createStatement()) {

				boolean delete = databaseExists(DB_NAME);
				if (delete) {
					String deleteDatabaseSQL = "DROP DATABASE IF EXISTS " + DB_NAME;
					statement.executeUpdate(deleteDatabaseSQL);

					System.out.println("Database deleted successfully.");
				} else {
					System.out.println("Database does not exists!");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean databaseExists(String dbName) {
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				Statement statement = connection.createStatement()) {

			String checkDatabaseSQL = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '"
					+ dbName + "'";
			return statement.executeQuery(checkDatabaseSQL).next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
