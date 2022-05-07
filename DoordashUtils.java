import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.*;

public class DoordashUtils {
    public static String generateJwt(String developerId, String keyId,String signingSecret){

        //Calculate the expiry Time Ex 5 mints
        Date now = new Date();
        Calendar time = Calendar.getInstance();
        time.add(Calendar.MINUTE, 5);
        Date expireTime = time.getTime(); // Set expiry after 5 mints

        //Create the headers
        Map<String, Object> headers = new HashMap();
        headers.put("alg", "HS256");
        headers.put("typ", "JWT");
        headers.put("dd-ver", "DD-JWT-V1");


        var decodedSecret =  Base64.getDecoder().decode(signingSecret.getBytes());
        String token = JWT.create()
                .withHeader(headers)
                .withIssuedAt(now)
                .withIssuer(developerId)
                .withClaim("kid", keyId)
                .withAudience("doordash")
                .withExpiresAt(expireTime)
                .sign(Algorithm.HMAC256(decodedSecret));

        return token;

    }
}
