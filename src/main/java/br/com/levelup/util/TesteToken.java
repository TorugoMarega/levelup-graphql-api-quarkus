package br.com.levelup.util;


import br.com.levelup.model.User;
import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtClaimsBuilder;
import io.smallrye.jwt.util.KeyUtils;

import java.security.PrivateKey;




public class TesteToken {

    public static void main(String[] args) throws Exception {

        String privateKeyLocation = "/privatekey.pem";
        PrivateKey privateKey = KeyUtils.readPrivateKey(privateKeyLocation);

        JwtClaimsBuilder claimsBuilder = Jwt.claims();

        User user = new User();
        user.setName("Pokemon");
        claimsBuilder.issuer("mp.jwt.verify.issuer");
        claimsBuilder.subject(user.getName());
        claimsBuilder.groups("admin");
        System.out.println(claimsBuilder.jws().signatureKeyId(privateKeyLocation).sign(privateKey));

    }


}
