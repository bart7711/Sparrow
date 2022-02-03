package kea.sparrow.entities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String text;

    @ManyToOne
    private User user;

    @Transient
    List<String> hashtag = new ArrayList<>();


    public Post(String text, User user){
        this.text = text;
        this.user = user;
        this.hashtag = Arrays.stream(text.split(" "))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.toList());
 }
}