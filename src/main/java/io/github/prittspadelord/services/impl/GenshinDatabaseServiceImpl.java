package io.github.prittspadelord.services.impl;

import io.github.prittspadelord.models.Character;
import io.github.prittspadelord.services.GenshinDatabaseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenshinDatabaseServiceImpl implements GenshinDatabaseService {

    private static final Logger LOG = LoggerFactory.getLogger(GenshinDatabaseServiceImpl.class);

    public void insertCharacter(Character character) {

        //pretend code that calls the datasource exists here
        LOG.info("Character inserted successfully!");
    }
}
