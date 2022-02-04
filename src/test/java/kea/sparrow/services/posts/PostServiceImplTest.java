package kea.sparrow.services.posts;

import kea.sparrow.entities.Post;
import kea.sparrow.entities.User;
import kea.sparrow.repositories.PostRepository;
import kea.sparrow.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PostServiceImplTest {

    @Autowired
    PostRepository postRepo;

    @Autowired
    UserRepository userRepo;


    PostServiceImpl postService;

    @BeforeEach
    public void initServices(){
        postService = new PostServiceImpl(postRepo, userRepo);
    }


    @Test
    @Sql("/createData.sql")
    void getAll() {
        long count = postService.getAll().size();
        assertEquals(3,count);
    }

    @Test
    @Sql("/createData.sql")
    void getById() {
        String name = postService.getById(1).getText();
        assertEquals("Test", name);
    }

    @Test
    @Sql("/createData.sql")
    void createPost() {
        User user = userRepo.findByUsername("bart").orElse(new User());
        Post post = new Post("Random text",user);
        System.out.println(post.getCreateDateTime());
        postService.createPost(post);
        long count = postService.getAll().size();
        assertEquals(4,count);
        assertEquals("Random text", post.getText());

    }

    @Test
    @Sql("/createData.sql")
    void deletePost() {
        postService.deletePost(1);
        long count = postService.getAll().size();
        assertEquals(2,count);
    }
}