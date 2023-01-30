package com.salaoagil.token;

import com.salaoagil.token.tokenassinatura.Token;
import com.salaoagil.token.tokenassinatura.TokenAdapter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Token token = new Token(UUID.randomUUID(), UUID.randomUUID(), LocalDateTime.now());
        String tokenHash = TokenAdapter.generateHashSignatureStart(token);
        System.out.println( "Hello World!" + tokenHash);

        String hashDecodado = TokenAdapter.decodarHashValidacao();
        System.out.println("Decodado:" + hashDecodado);
    }
}
