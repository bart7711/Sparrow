package kea.sparrow.dtos.converter;


import kea.sparrow.dtos.PostDTO;
import kea.sparrow.dtos.UserDTO;
import kea.sparrow.entities.Post;
import kea.sparrow.entities.User;
import kea.sparrow.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;


public class DTOConverter {
    ModelMapper modelMapper;
    UserRepository userRepository;

    @Autowired
    public DTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDTO convertToUserDTO(User user) {
        return  modelMapper.map(user, UserDTO.class);
    }

    public User convertToUser(UserDTO userDTO){
        return userRepository.findByUsername(userDTO.getUsername()).orElseThrow(() -> new ResourceNotFoundException("WTF"));
    }

    public PostDTO convertToPostDTO(Post post){
        PostDTO postDTO = modelMapper.map(post, PostDTO.class);
        postDTO.setUser(convertToUserDTO(post.getUser()));
        return postDTO;
    }
    public Post convertToPost(PostDTO postDTO){
            Post post = modelMapper.map(postDTO, Post.class);
            post.setUser(convertToUser(postDTO.getUser()));
            return post;

    }

}
