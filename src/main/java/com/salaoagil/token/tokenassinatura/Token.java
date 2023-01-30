package com.salaoagil.token.tokenassinatura;

import java.time.LocalDateTime;
import java.util.UUID;

public class Token {

    private UUID uuidAssinatura;
    private UUID uuidSignatario;
    private LocalDateTime validade;

    public Token(UUID uuidAssinatura, UUID uuidSignatario, LocalDateTime validade) {
        this.uuidAssinatura = uuidAssinatura;
        this.uuidSignatario = uuidSignatario;
        this.validade = validade;
    }

    public Token(String uuidAssinatura, String uuidSignatario, String validade) {
        this.uuidAssinatura = UUID.fromString(uuidAssinatura);
        this.uuidSignatario = UUID.fromString(uuidSignatario);
        this.validade = LocalDateTime.parse(validade);
    }

    public UUID getUuidAssinatura() {
        return uuidAssinatura;
    }

    public void setUuidAssinatura(UUID uuidAssinatura) {
        this.uuidAssinatura = uuidAssinatura;
    }

    public UUID getUuidSignatario() {
        return uuidSignatario;
    }

    public void setUuidSignatario(UUID uuidSignatario) {
        this.uuidSignatario = uuidSignatario;
    }

    public LocalDateTime getValidade() {
        return validade;
    }

    public void setValidade(LocalDateTime validade) {
        this.validade = validade;
    }
}
