package base.configuration;

import javax.sql.DataSource;

import org.apache.catalina.core.ApplicationContext;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * 
 * @author siwei
 *
 */
@Configuration
public class DalConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(DalConfiguration.class);

	/*
     * =============================== test datasource ============================================
     * 
	 */

	@Bean
	public DataSource dataSource() {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://192.168.0.143:3306/test?useUnicode=true&characterEncoding=utf-8";
		String username="root";
		String password="qwer1234";
		DataSource result=new PooledDataSource(driver, url, username,password);
		// tddlDataSource.setAppRuleFile(ruleFile);
		logger.info("database test inited!");
		return result;
	}
	
	@Bean
	public DataSource siweiDataSource() {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://192.168.0.143:3306/siwei?useUnicode=true&characterEncoding=utf-8";
		String username="root";
		String password="qwer1234";
		DataSource result=new PooledDataSource(driver, url, username,password);
		// tddlDataSource.setAppRuleFile(ruleFile);
		logger.info("database test inited!");
		return result;
	}


	/**
	 * TODO
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	@Bean
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(dataSource);
		// factory.setVfs(SpringbootVFS.class);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		String config="classpath:/mybatis/mybatis-test-config.xml";
		factory.setConfigLocation(resolver.getResource(config));
		Resource[] resources=new Resource[] {resolver.getResource("classpath:mapper/test/PersonMapper.xml")};
		factory.setMapperLocations((resources));

		return factory.getObject();
	}


	@Bean
	public MapperScannerConfigurer testMapperScannerConfigurer() {
		MapperScannerConfigurer result = new MapperScannerConfigurer();
		result.setBasePackage("base.mapper.test");
		result.setSqlSessionFactoryBeanName("testSqlSessionFactory");
		return result;
	}

	@Bean
	public PlatformTransactionManager testTransactionManager(@Qualifier("dataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
