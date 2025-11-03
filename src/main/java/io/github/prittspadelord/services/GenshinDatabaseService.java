package io.github.prittspadelord.services;

import io.github.prittspadelord.models.GenshinCharacter;

public interface GenshinDatabaseService {
    void insertCharacter(GenshinCharacter character);
}
