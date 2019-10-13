package edu.mum.cs.serveremployee.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DomainErrorDTO {

    private String field;
    private String message;

    public DomainErrorDTO(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
