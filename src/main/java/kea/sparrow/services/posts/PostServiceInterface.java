package kea.sparrow.services.posts;

import kea.sparrow.entities.Post;
import java.util.List;

public interface PostServiceInterface {
    List<Post> getAll();
    Post getById(int id);
    Post createPost(Post post);
    void deletePost(int postID);
}