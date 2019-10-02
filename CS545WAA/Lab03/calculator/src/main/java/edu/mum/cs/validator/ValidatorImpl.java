package edu.mum.cs.validator;

import edu.mum.cs.domain.Calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ValidatorImpl implements Validator{
    public List<String> validate(Object object) {
        List<String> errors = new ArrayList<String>();

        Calculator calculator = (Calculator) object;
        String add1 = calculator.getAdd1();
        if (add1 == null || add1.trim().isEmpty()  || !isNumeric(add1)) {
            errors.add("add1 must be a number");
        }
        String add2 = calculator.getAdd2();
        if (add2 == null || add2.trim().isEmpty() || !isNumeric(add2)) {
            errors.add("add2 must be a number");
        }
        String mult1 = calculator.getMult1();
        if (mult1 == null || mult1.trim().isEmpty() || !isNumeric(mult1)) {
            errors.add("mult1 must be a number");
        }
        String mult2 = calculator.getMult2();
        if (mult2 == null || mult2.trim().isEmpty() || !isNumeric(mult2)) {
            errors.add("mult2 must be a number");
        }
        return errors;
    }
    public static boolean isNumeric(String str) {
        try {
            new BigDecimal(str).toString();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
