package br.com.torugo.model;

import br.com.torugo.model.Skills.StrongWeakSkill;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User extends PanacheEntity {

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId
    @PrimaryKeyJoinColumn
    private Person person;

    @Column(length = 12)
    private String userMood = UserMood.NEUTRO.toString();


    private String username;


    private String email;


    private String password_hash;

    @Column(length = 6)
    private String color_hex;

    @Column(length = 20)
    private String role;


    private String profile_picture = "https://upload.wikimedia.org/wikipedia/commons/6/67/User_Avatar.png";


    private String profile_avatar = "https://cdn-icons-png.flaticon.com/512/147/147144.png";



    private Boolean deleted = false;

    @OneToMany(mappedBy = "user")
    private List<Hobbie>hobbies;

    @OneToMany(mappedBy = "user")
    private List<Speciality>specialties;

    @OneToMany(mappedBy = "user")
    private List<StrongWeakSkill>strongWeakSkills;

    public static List<User> findByUserNameContaining(String username) {
        return find("username like CONCAT('%',?1, '%') ", username).list();
    }

    public static List<User> findByPersonNameContaining(String name) {
        return find("person.first_name || person.last_name  like CONCAT('%',?1, '%') ", name).list();
    }

    public static List<User> findByDeleted(Boolean deleted) {
        return find("deleted", deleted).list();
    }

}
