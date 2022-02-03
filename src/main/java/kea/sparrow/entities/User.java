package kea.sparrow.entities;

import kea.sparrow.security.entities.Role;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@EqualsAndHashCode
public class User {

    @Basic
    @Column(nullable = false, length = 50)
    private String email;

    @Basic
    @Column(nullable = false, length = 72)  //72 == Max length of a bcrypt encoded password
    private String password;

    @Basic
    @Column(nullable = false,length = 200)
    private String description;

    @Id
    private String username;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_username"),
            inverseJoinColumns = @JoinColumn(name = "role_name"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user")
    Collection<Post> posts = new ArrayList<>();

    public User(String username, String email, String password, String description) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.description = description;
    }

    public User(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean addRole(Role role) {
        return roles.add(role);
    }

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}
}
