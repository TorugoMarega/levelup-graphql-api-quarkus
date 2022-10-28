package br.com.levelup.util;


import br.com.levelup.model.User;
import io.smallrye.jwt.algorithm.SignatureAlgorithm;
import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtClaimsBuilder;
import io.smallrye.jwt.util.KeyUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import static io.smallrye.jwt.util.KeyUtils.readPrivateKey;

@ApplicationScoped
public class GenerateToken {
    @ConfigProperty(name = "http://levelup.com/issuer")  String issuer;



    public String generateTokenJWT(User user) throws Exception {
        String privateKeyLocation = "privateKey.pem";
        PrivateKey privateKey = readPrivateKey(privateKeyLocation);
        

        JwtClaimsBuilder claimsBuilder = Jwt.claims();


        claimsBuilder.issuer("http://levelup.com/issuer");
        claimsBuilder.subject(user.getName());
        claimsBuilder.groups(user.getRole().toString());
        return claimsBuilder.jws().signatureKeyId(privateKeyLocation).sign(privateKey);

    }

    public static String removeBeginEnd(String pem) {
        pem = pem.replaceAll("-----BEGIN (.*)-----", "");
        pem = pem.replaceAll("-----END (.*)----", "");
        pem = pem.replaceAll("\r\n", "");
        pem = pem.replaceAll("\n", "");
        return pem.trim();
    }

    public static byte[] toEncodedBytes(final String pemEncoded) {
        final String normalizedPem = removeBeginEnd(pemEncoded);
        return Base64.getDecoder().decode(normalizedPem);
    }



    public static PrivateKey decodePrivateKey(final String pemEncoded) throws Exception {
        byte[] encodedBytes = toEncodedBytes(pemEncoded);

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encodedBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(keySpec);
    }

}


