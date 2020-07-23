package datapersistence.datapersistencelab.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {
    @Bean
    @ConfigurationProperties("com.danny.datasource")
    public DataSource getDataSource() {
        DataSourceBuilder dsb = DataSourceBuilder.create();
        dsb.url("jdbc:mysql://localhost:3306/plant?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

        return dsb.build();
    }

}
