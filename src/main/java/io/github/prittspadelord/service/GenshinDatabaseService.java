package io.github.prittspadelord.service;

import io.github.prittspadelord.models.Character;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service
public class GenshinDatabaseService {

    private static final Logger LOG = LoggerFactory.getLogger(GenshinDatabaseService.class);

    public void insertCharacter(Character character) {

        //pretend code that calls the datasource exists here
        LOG.info("Character inserted successfully!");
    }
}
