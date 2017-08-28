package dbutils;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.impl.C3P0Defaults;

import jdbc.utils.DataSourceUtils;

public class CURDemo {
	@Test
	public void f1() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "insert category values(?,?)";
		qr.update(sql,"c201","厨房电器");
	}
	@Test
	public void f2() throws SQLException{
		
		QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
		String sql = "update category set cname= ? where cid = ?";
		qr.update(sql,"达电器","c001");
	}
}
