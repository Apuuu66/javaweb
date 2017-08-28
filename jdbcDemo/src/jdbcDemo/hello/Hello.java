package jdbcDemo.hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import jdbc.utils.JdbcUtils1;

public class Hello {
	@Test
	public void f1() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/day07", "root", "111111");
		String sql = "select * from category";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(1) + "::" + rs.getString(2));
		}
		rs.close();
		st.close();
		connection.close();
	}
	@Test
	public void f2() {
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement st=null;
		try {
			conn=JdbcUtils1.getConnection();
			String sql = "insert into category values(?,?)";
			st=conn.prepareStatement(sql);
			st.setString(1, "c005");
			st.setString(2, "ЛЇЭт");
			int i=st.executeUpdate();
			if (i==1) {
				System.out.println("success!");
			}else{
				System.out.println("failed!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
