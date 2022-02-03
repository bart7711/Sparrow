package kea.sparrow.configuration;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Configuration
@Component
@Profile("!test")
public class DataSetup implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {


    }
}
