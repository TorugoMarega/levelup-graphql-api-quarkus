package br.com.torugo.model;

import br.com.torugo.model.Skills.SoftHardSkill;
import br.com.torugo.model.Skills.StrongWeakSkill;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.graphql.api.Nullable;
import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User extends PanacheEntity {

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "birthdate")
    @JsonbDateFormat(value = "dd/MM/yyyy", locale = "pt,br")
    private LocalDate birthdate;

    @Column(name = "cpf")
    private String cpf;

    @Column(length = 12)
    private String userMood = UserMood.NEUTRO.toString();

    //@Column(unique = true)
    private String username;

    //@Column(unique = true)
    private String email;


    private String password_hash;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @Nullable
    private Course course;

    @Column(length = 6)
    private String color_hex;

    @Column(length = 20)
    private Role role = Role.APPRENTICE;

    @Column(length = 20)
    private String classe;

    private String profile_picture = "https://upload.wikimedia.org/wikipedia/commons/6/67/User_Avatar.png";


    private String profile_avatar = "https://cdn-icons-png.flaticon.com/512/147/147144.png";




    @OneToMany(mappedBy = "user")
    private List<Hobbie>hobbies;

    @OneToMany(mappedBy = "user")
    private List<Speciality>specialties;

    @OneToMany(mappedBy = "user")
    private List<StrongWeakSkill>strongWeakSkills;

    @OneToMany(mappedBy = "user")
    private List<SoftHardSkill>softHardSkills;


    @JsonbDateFormat(value = "dd/MM/yyyy-hh:mm:ss", locale = "pt,br")
    private LocalDateTime creation_date = LocalDateTime.now();

    private Boolean deleted = false;

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