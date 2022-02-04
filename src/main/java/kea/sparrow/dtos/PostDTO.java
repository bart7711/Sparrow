package kea.sparrow.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDTO {
    private int id;
    private String text;
    private List<String> hashtag = new ArrayList<>();
    private UserDTO user;
    private LocalDateTime createDateTime;

    public PostDTO(int id, String text, List<String> hashtag, UserDTO user, LocalDateTime createDateTime) {
        this.id = id;
        this.text = text;
        this.hashtag = hashtag;
        this.user = user;
        this.createDateTime=createDateTime;
    }
}