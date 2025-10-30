package io.github.prittspadelord.services.impl;

import io.github.prittspadelord.models.GenshinCharacter;
import io.github.prittspadelord.services.GenshinDatabaseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenshinDatabaseServiceImpl implements GenshinDatabaseService {

    public void insertCharacter(GenshinCharacter character) {

        //pretend code that calls the datasource exists here
        log.info("Character inserted successfully!");
    }
}
