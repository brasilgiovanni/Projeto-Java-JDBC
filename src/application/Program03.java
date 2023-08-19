package application;

import java.util.Scanner;

import model.services.DatabaseManager;

public class Program03 {

	public static void main(String[] args) {
		//Create and Delete dataBase program
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the Create DataBase Method!");
		System.out.print("Please, enter the DataBase Name: ");
		String DB_NAME = sc.next();
		System.out.print("Now, please enter the correct password: ");
		String DB_PASSWORD_USER = sc.next();
		
		DatabaseManager.createDatabase(DB_NAME, DB_PASSWORD_USER); // criar um banco de dados
		
		System.out.println("---------------------------------------------------");
		
		System.out.println("Welcome to the Delete DataBase Method! Please carefull!");
		System.out.print("Please, enter the DataBase Name: ");
		DB_NAME = sc.next();
		System.out.print("Now, please enter the correct password: ");
		DB_PASSWORD_USER = sc.next();
		
		DatabaseManager.deleteDatabase(DB_NAME, DB_PASSWORD_USER); // deletar um banco de dados
	}

}
