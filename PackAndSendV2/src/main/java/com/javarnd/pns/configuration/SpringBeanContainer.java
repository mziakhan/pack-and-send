/**
 * This file is representation of Spring XML based configuration  
 * 
 * */
package com.javarnd.pns.configuration;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//import com.mzk.mascot.util.CSVReaderUtil;
//import com.mzk.mascot.util.FileUploadUtility;
@Configuration // IN XML -Spring config file, Treat as the configuration file for Spring
				// MVC-enabled applications.
@EnableCaching
/*
 * <mvc:annotation-driven/> (In XML) Enable Spring MVC-specific annotations
 * like @Controller
 */
@EnableWebMvc

/*
 * <tx:annotation-driven transaction-manager="txManager" />(In XML) Enable
 * Transaction management
 */
@EnableTransactionManagement
/*
 * <context:component-scan/> (In XML) Scan starts from base package and
 * registers all controllers, repositories, service, beans, etc.
 */

@ComponentScan(basePackages = "com.javarnd.pns")

/*
 * <util:properties id="props" location="classpath:dbconfig.properties" />
 */
@PropertySource({ "classpath:../dbconfig.properties" })
//@PropertySources({ @PropertySource("classpath:../dbconfig.properties"),
//		@PropertySource("classpath:../accessPath.properties") })

public class SpringBeanContainer {

	private final String DRIVER_CLASS = "DB_DRIVER_CLASS";
	private final String URL = "DB_URL";
	private final String USERNAME = "DB_USERNAME";
	private final String PASSWORD = "DB_PASSWORD";
	private final String ENTITY_SCAN_PKG = "ENTITY_SCAN_PKG";
//    private final String basePath = "C:\\ProjectUpload\\Upload";
	private final String basePath = "default.basePath";
	private final int MAX_UPLOAD_SIZE = 20 * 1024 * 1024;
	private final int MAX_FILE_COUNT = 100;
	private final String HBG_DIALECT = "hibernate.dialect";
	private final String HBG_SHOW_SQL = "hibernate.show_sql";
	private final String HBG_FORMAT_SQL = "hibernate.format_sql";
	private final String HBG_AUTO_DDL = "hibernate.hbm2ddl.auto";

	@Bean // Simple Bean Defination in XML
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty(DRIVER_CLASS));
		dataSource.setUrl(env.getProperty(URL));
		dataSource.setUsername(env.getProperty(USERNAME));
		dataSource.setPassword(env.getProperty(PASSWORD));
		return dataSource;
	}

//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//		JpaVendorAdapter hibernate = new HibernateJpaVendorAdapter();
//		entityManagerFactory.setDataSource(dataSource());
//		entityManagerFactory.setPackagesToScan(new String[] { env.getProperty(ENTITY_SCAN_PKG) });
//		entityManagerFactory.setJpaVendorAdapter(hibernate);
//		entityManagerFactory.setJpaProperties(hibernateProperties());
//		return entityManagerFactory;
//	}
	/*
	 * Prepare Hibernate Session Factory by specifying 1.DataSource
	 * setDataSource(dataSource()) 2.Entity Packages to be scanned (in properties
	 * file) setPackagesToScan(new String[] { env.getProperty(ENTITY_SCAN_PKG) })
	 * 3.Set hibernate properties like dialect,show_sql etc. setPackagesToScan(new
	 * String[] { env.getProperty(ENTITY_SCAN_PKG) })
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { env.getProperty(ENTITY_SCAN_PKG) });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	public Properties hibernateProperties() {
		final Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty(HBG_DIALECT, env.getProperty(HBG_DIALECT));
		hibernateProperties.setProperty(HBG_SHOW_SQL, env.getProperty(HBG_SHOW_SQL));
		hibernateProperties.setProperty(HBG_FORMAT_SQL, env.getProperty(HBG_FORMAT_SQL));
		hibernateProperties.setProperty(HBG_AUTO_DDL, env.getProperty(HBG_AUTO_DDL));
		return hibernateProperties;
	}

//	@Bean(name = "multipartResolver")
//	public CommonsMultipartResolver getMultipartResolver() {
//		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//		multipartResolver.setMaxUploadSize(MAX_UPLOAD_SIZE);
//		return multipartResolver;
//	}

//	@Bean
//	public FileUploadUtility fileuploadUtility() {
//		FileUploadUtility uploadUtility = new FileUploadUtility();
//		uploadUtility.setBasePath(env.getProperty(basePath));
//		uploadUtility.setMaxFileCount(MAX_FILE_COUNT);
//		return uploadUtility;
//	}

//	@Bean
//	public CSVReaderUtil csvReaderUtility() {
//		CSVReaderUtil readerUtil = new CSVReaderUtil();
//		return readerUtil;
//	}

//	@Bean
//	public PlatformTransactionManager transactionManager() {
//		JpaTransactionManager transactionManager = new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
//		return transactionManager;
//	}
	/*
	 * Enabling Transaction manager for Hibernate, handle by Spring itslef By
	 * using @Transactional annotation. Along with SessionFactory, Transaction
	 * manager is much needed for operations commit,rollback etc
	 */
	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	@Bean
	public EhCacheManagerFactoryBean  ehCacheManagerFactory() {
		EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cacheManagerFactoryBean.setShared(true);
		return cacheManagerFactoryBean;
	}

	@Bean
	public EhCacheCacheManager ehCacheCacheManager() {
		EhCacheCacheManager cacheManager = new EhCacheCacheManager();
		cacheManager.setCacheManager(ehCacheManagerFactory().getObject());
		cacheManager.setTransactionAware(true);
		return cacheManager;
	}

	@Autowired
	Environment env;
}
