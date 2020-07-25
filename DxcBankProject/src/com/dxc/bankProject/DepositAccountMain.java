package com.dxc.bankProject;

import java.sql.SQLException;
import java.util.Scanner;

public class DepositAccountMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int accountNo, depositAmount;
		System.out.println("Enter Account No  ");
		accountNo = sc.nextInt();
		System.out.println("Enter Deposit Amount  ");
		depositAmount = sc.nextInt();
		AccountDAO dao = new AccountDAO();
		try {
			System.out.println(dao.depositAccount(accountNo, depositAmount));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
