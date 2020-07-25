package com.dxc.bankProject;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateAccountMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int accountNo;
		String city, state;
		System.out.println("Enter Account No   ");
		accountNo=Integer.parseInt(sc.nextLine());
		System.out.println("Enter City   ");
		city = sc.nextLine();
		System.out.println("Enter State  ");
		state=sc.nextLine();
		AccountDAO dao = new AccountDAO();
		try {
			System.out.println(dao.updateAccount(accountNo, city, state));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
