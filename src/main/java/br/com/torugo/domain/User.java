package br.com.torugo.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User extends PanacheEntity {

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId
    @PrimaryKeyJoinColumn
    private Person person;

    @Enumerated(EnumType.STRING)
    private UserMood userMood = UserMood.NEUTRO;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password_hash")
    private String password_hash;

    @Column(name = "color_hex")
    private String color_hex;

    @Column(name = "profile_picture")
    private String profile_picture = "https://upload.wikimedia.org/wikipedia/commons/6/67/User_Avatar.png";

    @Column(name = "profile_avatar")
    private String profile_avatar = "https://cdn-icons-png.flaticon.com/512/147/147144.png";


    @Column(name = "deleted")
    private Boolean deleted = false;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getColor_hex() {
        return color_hex;
    }

    public void setColor_hex(String color_hex) {
        this.color_hex = color_hex;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public String getProfile_avatar() {
        return profile_avatar;
    }

    public void setProfile_avatar(String profile_avatar) {
        this.profile_avatar = profile_avatar;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public UserMood getUserMood() {
        return userMood;
    }

    public void setUserMood(UserMood userMood) {
        this.userMood = userMood;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }


}
