package kea.sparrow.services.posts;

import kea.sparrow.entities.Post;
import java.util.List;

public interface PostServiceInterface {
    List<Post> getAll();
    Post getById(int id);
    Post createPost(String text,String username);
    void deletePost(int postID);
}