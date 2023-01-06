package com.it.sim;

import java.sql.SQLException;

public class MainMethod {

	public static void main(String[] args) {
		try {
			String version = Dao.selectVersion();
			System.err.println(version);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
