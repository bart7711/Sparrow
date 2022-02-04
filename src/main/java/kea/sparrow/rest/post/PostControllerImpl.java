package kea.sparrow.rest.post;

import kea.sparrow.dtos.PostDTO;
import kea.sparrow.dtos.converter.DTOConverter;
import kea.sparrow.services.posts.PostServiceImpl;
import kea.sparrow.services.posts.PostServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostControllerImpl implements PostControllerInterface {

    PostServiceInterface postService;
    DTOConverter dtoConverter;

    @Autowired
    public PostControllerImpl(PostServiceInterface postService, DTOConverter dtoConverter) {
        this.postService = postService;
        this.dtoConverter = dtoConverter;
    }

    @Override
    public List<PostDTO> getAll() {
        return dtoConverter.convertToListOfPostDTOs(postService.getAll());
    }

    @Override
    public PostDTO getById(int id) {
        return dtoConverter.convertToPostDTO(postService.getById(id));
    }

    @Override
    public PostDTO createPost(String text, String username) {
        return dtoConverter.convertToPostDTO(postService
                .createPost(text,username));
    }

    @Override
    public void deletePost(int id) {
        postService.deletePost(id);
    }
}
