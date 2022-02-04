package kea.sparrow.configuration;


import kea.sparrow.entities.Post;
import kea.sparrow.entities.User;
import kea.sparrow.repositories.PostRepository;
import kea.sparrow.repositories.UserRepository;
import kea.sparrow.security.entities.ERole;
import kea.sparrow.security.entities.Role;
import kea.sparrow.security.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Configuration
@Component
@Profile("!test")
public class DataSetup implements CommandLineRunner {

    PostRepository postRepo;
    UserRepository userRepo;
    RoleRepository roleRepository;
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public DataSetup(PostRepository postRepo, UserRepository userRepo,
                     RoleRepository roleRepository, UserRepository userRepository,
                     PasswordEncoder passwordEncoder) {

        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        Role userRole = new Role();
        userRole.setName(ERole.ROLE_USER);

        roleRepository.save(userRole);

        User user1 = new User("user", "user@example.com", passwordEncoder.encode("test"),"Im an activist who donates blood");
        User user2 = new User("user1", "user1@example.com", passwordEncoder.encode("test"), "I want to kill myself");
        user1.addRole(userRole);
        user2.addRole(userRole);

        userRepository.save(user1);
        userRepository.save(user2);

        postRepo.save(new Post("I hate everyone",user1));
        postRepo.save(new Post("I love everyone", user2));
        postRepo.save(new Post("I want to die", user1));
        postRepo.save(new Post("I want to cry", user2));
        postRepo.save(new Post("I think earth is flat", user1));
        postRepo.save(new Post("Whatever", user2));
        postRepo.save(new Post("Test", user1));


    }
}
