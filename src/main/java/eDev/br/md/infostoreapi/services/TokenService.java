package eDev.br.md.infostoreapi.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import eDev.br.md.infostoreapi.models.UserModel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {


    public String generateToken(UserModel user) {

        return JWT.create()
                .withIssuer("Usuario")
                .withSubject(user.getUsername())
                .withClaim("uuid", String.valueOf(user.getUuid()))
                .withExpiresAt(LocalDateTime.now()
                        .plusHours(3).toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC256("authorization"));
    }

    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256("authorization"))
                .withIssuer("Usuario")
                .build().verify(token).getSubject();
    }
}
