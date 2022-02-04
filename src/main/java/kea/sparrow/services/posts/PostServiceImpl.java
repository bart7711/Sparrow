package kea.sparrow.services.posts;

import kea.sparrow.entities.Post;
import kea.sparrow.repositories.PostRepository;
import kea.sparrow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostServiceInterface {

    PostRepository postRepo;
    UserRepository userRepo;

    @Autowired
    public PostServiceImpl(PostRepository postRepo, UserRepository userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    @Override
    public List<Post> getAll() {return postRepo.findAll();}

    @Override
    public Post getById(int id) {
        return postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("There is no Post with id:" + id));
    }

    @Override
    public Post createPost(Post post) {
        return postRepo.save(post);
    }

    @Override
    public void deletePost(int postID) {
        if (!postRepo.existsById(postID)) {
            throw new ResourceNotFoundException("There is no such post in our system");
        }
        postRepo.deleteById(postID);
    }
}
