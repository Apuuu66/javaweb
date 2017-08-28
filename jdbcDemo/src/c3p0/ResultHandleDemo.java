package c3p0;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ResultHandleDemo {
	@Test
	public <T> void arrayHandler() throws Exception {
		QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
		String sql = "select * from category";
		Object[] query = qr.query(sql, new ArrayHandler());
		System.out.println(Arrays.toString(query));
	}

	@Test
	public void arrayListHandler() throws Exception {
		QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
		String sql = "select * from category";
		List<Object[]> query = qr.query(sql, new ArrayListHandler());
		for (Object[] objects : query) {
			System.out.println(Arrays.toString(objects));
			// System.out.println(objects.toString());
		}
	}

	@Test
	public void beanHandler() throws SQLException {
		QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
		String sql = "select * from category";
		Category query = qr.query(sql, new BeanHandler<>(Category.class));
		System.out.println(query);

	}

	@Test
	public void beanHandlerList() throws SQLException {
		QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
		String sql = "select * from category";
		List<Category> list = qr.query(sql, new BeanListHandler<>(Category.class));
		for (Category category : list) {
			System.out.println(category);
		}
	}

	@Test
	public void mapListHandler() throws SQLException {
		QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
		String sql = "select * from category";
		List<Map<String, Object>> query = qr.query(sql, new MapListHandler());
		for (Map<String, Object> map : query) {
			System.out.println(map);
			
		}
	}
}
