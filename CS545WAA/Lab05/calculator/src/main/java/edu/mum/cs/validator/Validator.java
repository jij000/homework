package edu.mum.cs.validator;

import java.util.List;

public interface Validator {
    public List<String> validate(Object domainObject);
}
