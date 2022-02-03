package kea.sparrow.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String userId;

    public PostDTO(int id, String text, List<String> hashtag, String userId) {
        this.id = id;
        this.text = text;
        this.hashtag = hashtag;
        this.userId = userId;
    }
}