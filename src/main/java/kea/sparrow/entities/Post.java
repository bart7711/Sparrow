package kea.sparrow.entities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime createDateTime;

    @ManyToOne
    private User user;

    @Transient
    List<String> hashtag = new ArrayList<>();

    public Post(String text, User user){
        this.text = text;
        this.user = user;
 }
}
