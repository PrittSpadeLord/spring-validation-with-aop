package io.github.prittspadelord.models;

import jakarta.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Character {
    @Pattern(regexp = "[a-zA-Z ]+") private String name;
    @Pattern(regexp = "anemo|geo|electro|dendro|hydro|pyro|cryo") private String element;
    @Pattern(regexp = "mondstadt|liyue|inazuma|sumeru|fontaine|natlan|nod_krai|snezhnaya") private String nation;
}
