package dao;

import java.util.List;

import model.HealthSystemUser;

public interface HealthSystemUserDAO {
	
	   public List<HealthSystemUser> getAllUsers();
	   public HealthSystemUser getUser(int userId);
	   public void updateUser(HealthSystemUser user);
	   public void deleteUser(HealthSystemUser user);

}
