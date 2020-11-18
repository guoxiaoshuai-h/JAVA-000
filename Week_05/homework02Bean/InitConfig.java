package fx.gxs.week05.homework02Bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-11-17 11:02
 */
@Configuration
public class InitConfig {

    @Bean
    public Address createAddress() {
        return new Address();
    }
}
