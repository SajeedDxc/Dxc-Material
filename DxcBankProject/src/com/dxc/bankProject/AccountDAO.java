package com.dxc.bankProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {

	Connection connection;
	PreparedStatement pst;
	
	public String withdrawAccount(int accountNo, int withdrawAmount) throws SQLException {
		String result = "";
		Account account = searchAccount(accountNo);
		connection = ConnectionHelper.getConnection();
		if (account != null) {
			int amount = account.getAmount();
			if (amount - withdrawAmount >= 1000) {
				String cmd = "Update Account SET Amount = Amount - ? "
						+ " WHERE AccountNo=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, withdrawAmount);
				pst.setInt(2, accountNo);
				pst.executeUpdate();
				pst.close();
				cmd = "Insert into accounttransaction(AccountNo, TranAmount,"
						+ "TranType) values(?, ?, ?)";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, accountNo);
				pst.setInt(2, withdrawAmount);
				pst.setString(3, "D");
				pst.executeUpdate();	
				result = "Amount Debited...";
			} else {
				result = "Insufficient Funds...";
			}
		} else {
			result = "Account No Not Found...";
		}
		return result;
	}
	public String depositAccount(int accountNo, int depositAmount) throws SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Update Account SET Amount = Amount + ? "
				+ " WHERE AccountNo=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, depositAmount);
		pst.setInt(2, accountNo);
		pst.executeUpdate();
		pst.close();
		cmd = "Insert into accounttransaction(AccountNo, TranAmount,"
				+ "TranType) values(?, ?, ?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, accountNo);
		pst.setInt(2, depositAmount);
		pst.setString(3, "C");
		pst.executeUpdate();
		return "Amount Credited...";
	}
	
	public String closeAccount(int accountNo) throws SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Update Account SET Status='inactive' WHERE "
				+ " AccountNo=?";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, accountNo);
		pst.executeUpdate();
		return "Account Closed...";
	}
	public String updateAccount(int accountNo, String city, String state) throws SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Update Account SET city=?, State=? WHERE AccountNo=?";
		pst=connection.prepareStatement(cmd);
		pst.setString(1, city);
		pst.setString(2, state);
		pst.setInt(3, accountNo);
		pst.executeUpdate();
		return "Account Updated Successfully...";
	}
	public Account searchAccount(int accountNo) throws SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Account Where AccountNo=?";
		Account account = null;
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, accountNo);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			account = new Account();
			account.setAccountNo(rs.getInt("accountNo"));
			account.setFirstName(rs.getString("firstName"));
			account.setLastName(rs.getString("lastName"));
			account.setCity(rs.getString("city"));
			account.setState(rs.getString("state"));
			account.setAmount(rs.getInt("amount"));
			account.setCheqFacil(rs.getString("cheqFacil"));
			account.setAccountType(rs.getString("accountType"));
		}
		return account;
	}
	
	public String createAccount(Account account) throws SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Insert INTO ACCOUNT(AccountNo,FirstName,LastName,City,State,Amount,CheqFacil,AccountType) " + 
				"values(?, ?, ?, ?, ?, ?, ?, ?)";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, account.getAccountNo());
		pst.setString(2, account.getFirstName());
		pst.setString(3, account.getLastName());
		pst.setString(4, account.getCity());
		pst.setString(5, account.getState());
		pst.setInt(6, account.getAmount());
		pst.setString(7, account.getCheqFacil());
		pst.setString(8, account.getAccountType());
		pst.executeUpdate();
		return "Account Created Successfully...";
	}
	
	public int generateAccountNo() throws SQLException {
		connection = ConnectionHelper.getConnection();
		int accountNo=0;
		pst=connection.prepareStatement("SELECT CASE WHEN MAX(ACCOUNTNO) IS NULL THEN 1 " + 
				"   ELSE MAX(ACCOUNTNO)+1 END accno FROM Account");
		ResultSet rs = pst.executeQuery();
		rs.next();
		accountNo = rs.getInt("accno");
		return accountNo;
	}
}
