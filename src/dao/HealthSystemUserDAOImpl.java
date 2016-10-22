package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Utility.ConnectionClass;
import model.HealthSystemUser;

public class HealthSystemUserDAOImpl implements HealthSystemUserDAO{

	@Override
	public List<HealthSystemUser> getAllUsers() {
		Connection dbConnection = null;
		Statement statement = null;
		List<HealthSystemUser> healthSystemUsers = new ArrayList<>();

		String selectTableSQL = "SELECT ID, NAME from HEALTHSYSTEM_USER";

		try {
			dbConnection = ConnectionClass.getConnection();
			statement = dbConnection.createStatement();
			System.out.println(selectTableSQL);

			// execute select SQL stetement
			ResultSet rs = statement.executeQuery(selectTableSQL);

			while (rs.next()) {

				String userid = rs.getString("USER_ID");
				String username = rs.getString("USERNAME");

				System.out.println("userid : " + userid);
				System.out.println("username : " + username);

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return healthSystemUsers;
	}

	@Override
	public HealthSystemUser getUser(int userId) {
		return null;
	}

	@Override
	public void updateUser(HealthSystemUser user) {
		
	}

	@Override
	public void deleteUser(HealthSystemUser user) {
		
	}

	public static void main(String[] args) {
		HealthSystemUserDAO healthSystemUserDAO = new HealthSystemUserDAOImpl();
		healthSystemUserDAO.getAllUsers();
	}
}
