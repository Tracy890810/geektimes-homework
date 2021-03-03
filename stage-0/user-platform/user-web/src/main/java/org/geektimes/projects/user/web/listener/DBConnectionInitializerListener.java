package org.geektimes.projects.user.web.listener;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.repository.UserRepository;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.impl.UserServiceImpl;
import org.geektimes.projects.user.sql.DBConnectionManager;

@WebListener
public class DBConnectionInitializerListener implements ServletContextListener {

	private static final Logger LOG = Logger.getLogger(DBConnectionInitializerListener.class.getName());

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {

			Context context = new InitialContext();

			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/UserPlatformDB");

			if (dataSource != null) {
				LOG.log(Level.INFO, "成功通过jndi配置datasource");
			}

			DBConnectionManager dbConnectionManager = new DBConnectionManager();

			UserRepository userRepo = new DatabaseUserRepository(dbConnectionManager);

			UserService userService = new UserServiceImpl(userRepo);

			sce.getServletContext().setAttribute("dbConnectionManager", dbConnectionManager);
			sce.getServletContext().setAttribute("userRepo", userRepo);
			sce.getServletContext().setAttribute("userService", userService);

		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getLocalizedMessage());
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		DBConnectionManager dbConnectionManager = (DBConnectionManager) sce.getServletContext().getAttribute(
				"dbConnectionManager");
		dbConnectionManager.releaseConnection();
	}
}
