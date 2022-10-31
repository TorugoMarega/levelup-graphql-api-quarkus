package br.com.levelup.model;

import br.com.levelup.model.Skills.StrongWeakSkill;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.graphql.api.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
/**Classe para objetos do tipo User, onde serão contidos, valores e métodos para o mesmo.
 * Os métodos acessores e construtores estão definidos pelo Lombok. pelas Annotations @Getter, @Setter, @AllArgsConstructor e @NoArgsConstructor
 * @author Victor Hugo Marega
 * @version 1.0
 */
@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends PanacheEntity {
    /**Atributo para manipular o nome de um objeto User. Mapeado pelo Hibernate ORM*/
    @Column(name = "name")
    private String name;

    /**Atributo para manipular a data de nascimento de um objeto User. Mapeado pelo Hibernate ORM e a formatação definida para o padrão PT-BR*/
    @Column(name = "birthdate")
    @JsonbDateFormat(value = "dd/MM/yyyy", locale = "pt,br")
    private LocalDate birthdate;

    /**Atributo para manipular o CPF de um objeto User. Mapeado pelo Hibernate ORM, é um campo definido como único e aceita no máximo 11 caracteres*/
    @Column(name = "cpf",  unique = true, length = 11)
    private String cpf;

    /**Atributo para manipular o campo humor de um objeto User. userMood é uma String de caracteres no padrão Unicode e são emojis que representam o humor do User, estão predefinidos no Enum UserMood do pacote Model. Mapeado pelo Hibernate ORM, é um campoque aceita no máximo 12 caracteres*/
    @Column(length = 12)
    private String userMood = UserMood.NEUTRO.toString();

    /**Atributo para manipular o nome de usuário de um objeto User. Mapeado pelo Hibernate ORM, é um campo definido como único*/
    @Column(unique = true)
    private String username;

    /**Atributo para manipular o email de um objeto User. Mapeado pelo Hibernate ORM, é um campo definido como único*/
    @Column(unique = true)
    private String email;

    /**Atributo para manipular a senha de um objeto User. Mapeado pelo Hibernate ORM*/
    private String password_hash;


    /**Atributo para manipular as informações acadêmicas de um objeto User. Mapeado pelo Hibernate ORM, e faz referência a uma tabela no banco de dados que junta um objeto User e um objeto College*/
    @ManyToOne
    @JoinColumn(name = "college_id")
    @Nullable
    private College collegeInformation;

    /**Atributo para manipular uma cor no padrão hexadecimal de um objeto User. Mapeado pelo Hibernate ORM e aceita no máximo 6 caracteres*/
    @Column(length = 6)
    private String color_hex;

    /**Atributo para manipular o cargo de um objeto User. É um objeto do tipo Role que é um Enum, podendo receber os valores APPRENTICE ou ADMIN. Mapeado pelo Hibernate ORM, armazenando uma String no banco de dados*/
    @Column(length = 20)
    private Role role = Role.APPRENTICE;

    /**Atributo para manipular uma classe de um objeto User, este campo se refere a uma classe de personagem de rpg, por exemplo: Mago, cavaleiro, bruxa, fada, etc. Mapeado pelo Hibernate ORM e aceita no máximo 20 caracteres*/
    @Column(length = 20)
    private String classe;

    /**Atributo para manipular uma foto de perfil no padrão Base64 de um objeto User. Mapeado pelo Hibernate ORM. É uma cadeia de caracteres que ao ser consumida pelo HTML será convertida para imagem. Tem um valor pré definido de uma imagem padrão que todos os usuários recebem ao serem criados. A imagem deverá ser convertida no Front End e retornar a String Base64 para salvá-la no banco de dados*/
    @Lob
    private String profile_picture="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";

    /**Atributo para manipular uma foto de acatar no padrão Base64 de um objeto User. Mapeado pelo Hibernate ORM. É uma cadeia de caracteres que ao ser consumida pelo HTML será convertida para imagem. Tem um valor pré definido de uma imagem padrão que todos os usuários recebem ao serem criados. A imagem deverá ser convertida no Front End e retornar a String Base64 para salvá-la no banco de dados*/
    @Lob
    private String profile_avatar="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";

    /**Atributo para manipular uma lista de hobbies de um objeto User. Mapeado pelo Hibernate ORM. É uma lista de objetos Hobbies e mapeada pela classe User.*/
    @OneToMany(mappedBy = "user")
    private List<Hobbie>hobbies;

    /**Atributo para manipular uma lista de especialidades de um objeto User. Mapeado pelo Hibernate ORM. É uma lista de objetos Specialities e mapeada pela classe User.*/
    @OneToMany(mappedBy = "user")
    private List<Speciality>specialties;

    /**Atributo para manipular uma lista de Competências fracas ou Fortes de um objeto User. Mapeado pelo Hibernate ORM. É uma lista de objetos StrongWeakSkill e mapeada pela classe User, o que define o tipo de Skill é um Enum que pode receber os valores STRONG ou WEAK.*/
    @OneToMany(mappedBy = "user")
    private List<StrongWeakSkill>strongWeakSkills;

    /**Atributo para manipular uma lista de Competências técnicas ou comportamentais de um objeto User. Mapeado pelo Hibernate ORM. É uma lista de objetos UserSoftHardSkill e mapeada pela classe User, o que define o tipo de Skill é um Enum que pode receber os valores SOFT ou HARD.*/
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<UserSoftHardSkill> softHardSkills;

    /**Atributo para manipular a data e hora de criação de um objeto User. Mapeado pelo Hibernate ORM e a formatação definida para o padrão PT-BR*/
    @JsonbDateFormat(value = "dd/MM/yyyy-hh:mm:ss", locale = "pt,br")
    private LocalDateTime creation_date = LocalDateTime.now();

    /**Atributo para manipular o campo deleted que é um Boolean, pode ser definido como True ou False. Mapeado pelo Hibernate ORM. O usuário nunca é deletado do banco de dados, apenas tem este campo definido como True, por padrão ele vem definido como False.*/
    private Boolean deleted = false;

    /**Método para consultar no banco de dados e retornar uma lista de objetos do tipo User filtrados pelo campo username.
     * @param username
     *Lista de usuários que possuem no atributo username a cadeia de caracteres passada como parâmetro do método.
     * */
    public static List<User> findByUserNameContaining(String username) {
        return find("username like CONCAT('%',?1, '%') ", username).list();
    }

    /**Método para consultar no banco de dados e retornar uma lista de objetos do tipo User filtrados pelo campo name.
     * @param name
     * @return Lista de usuários que possuem no atributo name a cadeia de caracteres passada como parâmetro do método.
     * */
    public static List<User> findByNameContaining(String name) {
        return find("name like CONCAT('%',?1, '%') ", name).list();
    }

    /**Método para consultar no banco de dados e retornar uma lista de objetos do tipo User filtrados pelo campo deleted. Pode ser passado como parâmetro TRUE ou FALSE, se for TRUE o retorno será uma lista de usuários inativos, e FALSE uma lista de usuários ativos.
     * @param deleted
     * @return Lista de usuários ativos ou inativos de acordo com o valor passado no atributo deleted como parâmetro do método.
     * */
    public static List<User> findByDeleted(Boolean deleted) {
        return find("deleted", deleted).list();
    }

}