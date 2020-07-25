package com.dxc.bankProject;

import java.sql.SQLException;
import java.util.Scanner;

public class WithdrawAccountMain {
	public static void main(String[] args) {
		int accountNo, withdrawAmount;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter AccountNo   ");
		accountNo = sc.nextInt();
		System.out.println("Enter Withdraw Amount   ");
		withdrawAmount = sc.nextInt();
		AccountDAO dao = new AccountDAO();
		try {
			System.out.println(dao.withdrawAccount(accountNo, withdrawAmount));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
