
package controller.Postgre;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@PropertySource("classpath:/application.properties")
@EnableTransactionManagement
public class PostgreKonfigurazioa {

    /**
     * Definición del DataSource para la conexión a nuestra base de datos.
     * Las propiedades son establecidas desde el fichero de properties, y
     * asignadas usando el objeto env.
     *
     */
    @Bean
    public DataSource dataSourceIn() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("dbin.driver"));
        dataSource.setUrl(env.getProperty("dbin.url"));
        dataSource.setUsername(env.getProperty("dbin.username"));
        dataSource.setPassword(env.getProperty("dbin.password"));
        return dataSource;
    }

 
    /**
     *
     * Declaración del EntityManagerFactory de JPA
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

        //Le asignamos el dataSource que acabamos de definir.
        entityManagerFactory.setDataSource(dataSourceIn());

        // Le indicamos la ruta donde tiene que buscar las clases anotadas
        entityManagerFactory.setPackagesToScan(env.getProperty("entitymanagerin.packagesToScan"));

        // Implementación de JPA a usar: Hibernate
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

        // Propiedades de Hibernate
        Properties additionalProperties = new Properties();
        additionalProperties.put("hibernate.dialect", env.getProperty("hibernatein.dialect"));
        additionalProperties.put("hibernate.show_sql", env.getProperty("hibernatein.show_sql"));
        additionalProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernatein.hbm2ddl.auto"));
        entityManagerFactory.setJpaProperties(additionalProperties);

        return entityManagerFactory;
    }

    /**
     * Inicializa y declara el gestor de transacciones
     */
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
        return transactionManager;
    }

    /**
     *  
     * Este bean es un postprocessor que ayuda a relanzar las excepciones específicas
     * de cada plataforma en aquellas clases anotadas con @Repository
     *
     */
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public AccountMoveDao getAccountModeDao() {
    	return new AccountMoveDao();
    }
    
    @Bean
    public PaymentTransactionDao getPaymentTransactionDao() {
    	return new PaymentTransactionDao();
    }
    
    @Bean
    public PurchaseOrderDao getPurchaseOrderDao() {
    	return new PurchaseOrderDao();
    }
    
    @Bean
    public PurchaseOrderLineDao getPurchaseOrderLineDao() {
    	return new PurchaseOrderLineDao();
    }
    
    @Bean
    public ResPartnerDao getResPartnerDao() {
    	return new ResPartnerDao();
    }
    
    @Bean
    public ProductDao getProductDao() {
    	return new ProductDao();
    }
    
    @Bean
    public SaleOrderDao getSaleOrderDao() {
    	return new SaleOrderDao();
    }
    
    
    @Autowired
    private Environment env;

    
    @Autowired
    private LocalContainerEntityManagerFactoryBean entityManagerFactory;

  
}