package io.github.prittspadelord;

import io.github.prittspadelord.config.SpringAppConfig;

import io.github.prittspadelord.models.Character;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Set;

public class SpringValidationWithAopApplication {
    static void main() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        Validator validator = context.getBean(Validator.class);

        Character character = new Character();
        character.setName("Chiori");
        character.setElement("geo");
        character.setNation("inazuma");
    }
}