package br.com.levelup.service;


import br.com.levelup.model.Login;
import br.com.levelup.model.User;
import br.com.levelup.util.GenerateToken;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class LoginService {

    GenerateToken generateToken = new GenerateToken();



    UserService userService = new UserService();

    public LoginService() {
    }

    @Transactional
    public String login(Login login){
        User user = userService.findByUserName(login.getNome()).get(0);

     

        String token;
        if(login.getSenha().equals(user.getPassword_hash())) {
            try {
                token = generateToken.generateTokenJWT(user);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return token;
        }else {

            return "Usuário ou senha inválido";
        }

        }

}
