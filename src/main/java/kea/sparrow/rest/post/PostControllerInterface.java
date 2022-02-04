package kea.sparrow.rest.post;

import kea.sparrow.dtos.PostDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PostControllerInterface {
    @GetMapping
    List<PostDTO> getAll();

    @GetMapping("/{id}")
    PostDTO getById(@PathVariable int id);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PostDTO createPost(@RequestBody PostDTO postDTO);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePost(@PathVariable("id") int id);

}
