package com.salaoagil.token.tokenassinatura;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.UUID;

public class TokenAdapter {

    private static final String UTF8 = "UTF-8";
    private static final String SEPARATOR = ";";
    private static final String SECRET_KEY = "bWFyaWE7YTY2NWE0NTkyMDQyMmY5ZDQx";

    public static String generateHashSignatureStart(Token token){
        try {
            StringBuilder builderHash = new StringBuilder();
            builderHash
                    .append(token.getUuidAssinatura())
                    .append(SEPARATOR)
                    .append(token.getUuidSignatario())
                    .append(SEPARATOR)
                    .append(token.getValidade())
                    .append(SEPARATOR)
                    .append(sha256(SECRET_KEY));
            return URLEncoder.encode(Base64.encodeBase64URLSafeString(builderHash.toString().getBytes()), UTF8);
        } catch (UnsupportedEncodingException e) {
            //return null
        }
        return null;
    }

    private static String sha256(String value) {
        try {
            final MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.reset();
            messageDigest.update(value.getBytes(Charset.forName("UTF8")));
            final byte[] resultByte = messageDigest.digest();
            return new String(Hex.encodeHex(resultByte));
        } catch (NoSuchAlgorithmException e) {
            //return null
        }
        return null;
    }

    public static String decodarHashValidacao(){
        Token token = new Token(UUID.randomUUID(), UUID.randomUUID(), LocalDateTime.now());
        String hash = generateHashSignatureStart(token);

        byte[] decodedBytes = Base64.decodeBase64(hash);
        String decodedString = new String(decodedBytes);

        return decodedString;
    }
}
