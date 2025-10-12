package io.github.prittspadelord.advices;

import io.github.prittspadelord.models.Character;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ValidateCharacter implements MethodInterceptor {

    private Validator validator;
    private static final Logger LOG = LoggerFactory.getLogger(ValidateCharacter.class);

    public ValidateCharacter(@Autowired Validator validator) {
        this.validator = validator;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Object[] args = invocation.getArguments();

        if(args.length != 1) {
            throw new IllegalArgumentException("Incorrect amount of arguments. Expected " + 1 + ", but found " + args.length + ".");
        }

        if(!Character.class.equals(args[0].getClass())) {
            throw new IllegalArgumentException("Incorrect argument type, expected " + Character.class.getName() + ", but found " + args[0].getClass().getName() + ".");
        }

        Character character = (Character) args[0];

        Set<ConstraintViolation<Character>> violations = validator.validate(character);

        if(violations.isEmpty()) {
            LOG.info("Validation check passed");
            return invocation.proceed();
        }
        else {
            //WIP
            return null;
        }
    }
}
