package edu.mum.cs.serveremployee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorDTO handleValidationError(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrorList = result.getFieldErrors();

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setErrorType("ValidationError");

        for (FieldError fieldError : fieldErrorList) {
            errorDTO.addDomainError(new DomainErrorDTO(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return errorDTO;
    }

}
