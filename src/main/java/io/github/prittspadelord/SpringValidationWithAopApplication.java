package io.github.prittspadelord;

import io.github.prittspadelord.config.SpringAppConfig;
import io.github.prittspadelord.models.Character;
import io.github.prittspadelord.services.GenshinDatabaseService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringValidationWithAopApplication {
    static void main() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        Character character = new Character();
        character.setName("Chiori");
        character.setElement("geo");
        character.setNation("inazuma");

        GenshinDatabaseService service = context.getBean(GenshinDatabaseService.class);

        service.insertCharacter(character);
    }
}