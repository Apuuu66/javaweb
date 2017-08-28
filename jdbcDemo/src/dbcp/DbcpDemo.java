package dbcp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import jdbc.utils.JdbcUtils;

public class DbcpDemo {
	@Test
	public void f1() throws Exception {
		BasicDataSource dSource = new BasicDataSource();
		dSource.setDriverClassName("com.mysql.jdbc.Driver");
		dSource.setUrl("jdbc:mysql:///day07");
		dSource.setUsername("root");
		dSource.setPassword("111111");
		Connection conn = dSource.getConnection();
		String sql = "insert category values(?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, "c011");
		st.setString(2, "“˚¡œ");
		int i = st.executeUpdate();
		System.out.println(i);
		JdbcUtils.closeResource(conn, st, null);
	}
	@Test
	public void f2() throws Exception{
		Properties prop=new Properties();
		prop.load(new FileInputStream("src/dbcp.properties"));
		DataSource ds = new BasicDataSourceFactory().createDataSource(prop);
		Connection conn = ds.getConnection();
		
	}

}
