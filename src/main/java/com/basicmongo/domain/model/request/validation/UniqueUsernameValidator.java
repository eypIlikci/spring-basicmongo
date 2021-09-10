package com.basicmongo.domain.model.request.validation;

import com.basicmongo.domain.User;
import com.basicmongo.repository.UserRepository;;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String> {
    @Autowired
    private UserRepository userRepository;
    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        if (userRepository.findByUsername(username).isPresent())
            return false;
        return true;
    }
}
