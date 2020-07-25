package com.dxc.bankProject;

import java.sql.SQLException;
import java.util.Scanner;

public class SearchAccountMain {
	public static void main(String[] args) {
		int accountNo;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Account No");
		accountNo=sc.nextInt();
		AccountDAO dao = new AccountDAO();
		try {
			Account accountFound = dao.searchAccount(accountNo);
			if (accountFound!=null) {
				System.out.println(accountFound);
			} else {
				System.out.println("AccountNo Does Not Exist...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
