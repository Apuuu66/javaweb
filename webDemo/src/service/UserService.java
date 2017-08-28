package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import domain.User;

/**
 * Servlet implementation class UserService
 */
public class UserService extends HttpServlet {

	public User login(String username, String password) {
		// TODO Auto-generated method stub
		 UserDao userDao = new UserDao();
		return userDao.getUserByusernameAndPwd(username,password);
	}

}
