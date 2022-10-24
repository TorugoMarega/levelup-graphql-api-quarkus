package br.com.levelup.model;

import br.com.levelup.model.Skills.StrongWeakSkill;
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
    private String name;

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

//    @ManyToOne
//    @JoinColumn(name = "course_id")
//    @Nullable
//    private Course course;


    @ManyToOne
    @JoinColumn(name = "college_id")
    @Nullable
    private College collegeInformation;


    @Column(length = 6)
    private String color_hex;

    @Column(length = 20)
    private Role role = Role.APPRENTICE;

    @Column(length = 20)
    private String classe;

    @Lob
    private String profile_picture="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";
    @Lob
    private String profile_avatar="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";


    @OneToMany(mappedBy = "user")
    private List<Hobbie>hobbies;

    @OneToMany(mappedBy = "user")
    private List<Speciality>specialties;

    @OneToMany(mappedBy = "user")
    private List<StrongWeakSkill>strongWeakSkills;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<UserSoftHardSkill> softHardSkills;


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