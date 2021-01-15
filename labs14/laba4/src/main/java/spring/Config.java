package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.AccountService;
import service.FileAccountService;

import java.io.IOException;

@Configuration
public class Config {

    @Bean
    public AccountService getAccService() throws IOException {
        return new FileAccountService();
    }
}
