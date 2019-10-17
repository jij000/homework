package edu.mum.cs.serveremployee.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ErrorDTO {
    private String errorType;
    private List<DomainErrorDTO> fieldErrors = new ArrayList<>();

    public void addDomainError(DomainErrorDTO domainError) {
        fieldErrors.add(domainError);
    }
}
