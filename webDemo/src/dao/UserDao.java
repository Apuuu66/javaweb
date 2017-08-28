package dao;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import domain.User;
import utils.DataSourceUtils;

/**
 * Servlet implementation class UserDao
 */
public class UserDao extends HttpServlet {

	public User getUserByusernameAndPwd(String username, String password) {
		// TODO Auto-generated method stub
		//´´½¨quaryrunner
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from user where username = ? and password = ?";
		try {
			return qr.query(sql, new BeanHandler<User>(User.class), username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
