package configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import daos.BlogDAO;
import daos.BlogDAOImpl;
import daos.ChatDAO;
import daos.ChatDAOImpl;
import daos.EventDAO;
import daos.EventDAOImpl;
import daos.ForumDAO;
import daos.ForumDAOImpl;
import daos.FriendDAO;
import daos.FriendDAOImpl;
import daos.JobDAO;
import daos.JobDAOImpl;
import daos.UserDAO;
import daos.UserDAOImpl;
import models.BaseDomain;
import models.Blog;
import models.BlogComment;
import models.Chat;
import models.Event;
import models.EventComment;
import models.Forum;
import models.ForumComment;
import models.Friend;
import models.Job;
import models.JobApplication;
import models.User;

@Configuration
@ComponentScan("com.comingtogether")
@EnableTransactionManagement


public class applicationcontextconfig 
{
		@Bean(name = "dataSource")
		public DataSource getOracleDataSource() {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");

			dataSource.setUsername("ankita");
			dataSource.setPassword("anki25");
			return dataSource;
		}

		private Properties getHibernateProperties() {

			Properties connectionProperties = new Properties();

			connectionProperties.setProperty("hibernate.show_sql", "true");
			connectionProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			connectionProperties.setProperty("hibernate.hbm2ddl.auto", "update");
			connectionProperties.setProperty("hibernate.format_sql", "true");
			connectionProperties.setProperty("hibernate.jdbc.use_get_generated_keys", "true");
			// dataSource.setConnectionProperties(connectionProperties);
			return connectionProperties;
		}

		@Autowired // automatically bean is created n injected
		@Bean(name = "sessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource) {

			LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource); // sessionBuilder
																									// can
																									// b
																									// any
																									// other
																									// name
																									// too
			sessionBuilder.addProperties(getHibernateProperties());
			sessionBuilder.addAnnotatedClass(User.class);
			sessionBuilder.addAnnotatedClass(Blog.class);
			sessionBuilder.addAnnotatedClass(BaseDomain.class);
			sessionBuilder.addAnnotatedClass(BlogComment.class);
			// sessionBuilder.addAnnotatedClass(Chat.class);
			sessionBuilder.addAnnotatedClass(Event.class);
			sessionBuilder.addAnnotatedClass(EventComment.class);
			sessionBuilder.addAnnotatedClass(ForumComment.class);
			sessionBuilder.addAnnotatedClass(Forum.class);
			sessionBuilder.addAnnotatedClass(Friend.class);
			sessionBuilder.addAnnotatedClass(Job.class);
			sessionBuilder.addAnnotatedClass(JobApplication.class);
			return sessionBuilder.buildSessionFactory();
		}

		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory); // should
																												// be
																												// same
																												// name
																												// as
																												// bean
																												// name
																												// of
																												// session
																												// factory
			return transactionManager;
		}

		@Autowired
		@Bean(name = "user")
		public User getUser() {
			return new User();
		}

		@Autowired
		@Bean(name = "userDAO")
		public UserDAO getUserDAO(SessionFactory sessionFactory) {
			return new UserDAOImpl(sessionFactory);
		}

		/*@Autowired
		@Bean(name = "blog")
		public Blog getBlog() {
			return new Blog();
		}*/

		@Autowired
		@Bean(name = "blogDAO")
		public BlogDAO getBlogDAO(SessionFactory sessionFactory) {
			return new BlogDAOImpl(sessionFactory);
		}

		@Autowired
		@Bean(name = "jobDAO")
		public JobDAO getJobDAO(SessionFactory sessionFactory) {
			return new JobDAOImpl(sessionFactory);
		}

		@Autowired
		@Bean(name = "chatDAO")
		public ChatDAO getChatDAO(SessionFactory sessionFactory) {
			return new ChatDAOImpl(sessionFactory);
		}

		@Autowired
		@Bean(name = "eventDAO")
		public EventDAO getEventDAO(SessionFactory sessionFactory) {
			return new EventDAOImpl(sessionFactory);
		}

		@Autowired
		@Bean(name = "forumDAO")
		public ForumDAO getForumDAO(SessionFactory sessionFactory) {
			return new ForumDAOImpl(sessionFactory);
		}
		
		@Autowired
		@Bean(name = "friendDAO")
		public FriendDAO getFriendDAO(SessionFactory sessionFactory) {
			return new FriendDAOImpl(sessionFactory);
		}

	}