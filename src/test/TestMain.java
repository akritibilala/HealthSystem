package test;

import controller.UserDao;

public class TestMain {
	
	public static void main(String[] args) {
		UserDao user = new UserDao();
		user.getRecommendations();
	}

}
