package com.colorcc.user.mapper.test.base;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySQLDbTestInitialization implements DbTestInitialization {
	private static final Logger logger = LoggerFactory.getLogger(MySQLDbTestInitialization.class);

	private Map<String, String> dbPropertyMap = new HashMap<String, String>();

	public Map<String, String> getdbPropertyMap() {
		return dbPropertyMap;
	}

	private final static String TEST_ENV_PROPERTIES = "WEB-INF/test/config/test_db.properties";
	// private final static String INIT_SQL_FILE = "WEB-INF/test/config/init_database.sql";
	private final static String INIT_SQL_FILE = "WEB-INF/schema/colorcc_mysql_schema.sql";

	private void initDbProperties() throws IOException {
		Properties dbProperties = Resources.getResourceAsProperties(TEST_ENV_PROPERTIES);
		for (Entry<Object, Object> entry : dbProperties.entrySet()) {
			dbPropertyMap.put((String) entry.getKey(), (String) entry.getValue());
		}
	}

	@Override
	public boolean canInit() {
		try {
			initDbProperties();
			if (dbPropertyMap.get("db.product.name").trim().toUpperCase().equals("MYSQL")) {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void dropOrCreateDatabae(String action) {

		String dropDbScript = dbPropertyMap.get("ddl." + action + ".database.script");

		if (logger.isInfoEnabled()) {
			logger.info("Run script [ " + dropDbScript + " ]");
		}
		Connection connection = null;
		try {
			Class.forName(dbPropertyMap.get("db.jdbc.test.driver"));
			connection = DriverManager.getConnection(dbPropertyMap.get("db.jdbc.test.default.url"), dbPropertyMap.get("db.jdbc.test.default.username"),
					dbPropertyMap.get("db.jdbc.test.default.password"));
			connection.createStatement().execute(dropDbScript);
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info(" Run script [ " + dropDbScript + "] failure.");
			}
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqlExe) {
					sqlExe.printStackTrace();
				}
			}
		}
	}

	@Override
	public void initDatabase() {
		if (logger.isInfoEnabled()) {
			logger.info("Init database ... ");
		}

		Connection connection = null;
		try {

			Reader reader = Resources.getResourceAsReader(INIT_SQL_FILE);

			Class.forName(dbPropertyMap.get("db.jdbc.test.driver"));
			connection = DriverManager.getConnection(dbPropertyMap.get("db.jdbc.test.url"), dbPropertyMap.get("db.jdbc.test.username"), dbPropertyMap.get("db.jdbc.test.password"));
			reader = Resources.getResourceAsReader(INIT_SQL_FILE);
			ScriptRunner runner = new ScriptRunner(connection);
			runner.setLogWriter(null);
			runner.runScript(reader);
			reader.close();
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info(" Run script [ " + INIT_SQL_FILE + "] failure.");
			}
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqlExe) {
					sqlExe.printStackTrace();
				}
			}
		}
	}

}
