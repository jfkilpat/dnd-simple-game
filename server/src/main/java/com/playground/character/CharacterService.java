package com.playground.character;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    private Gson gson = new Gson();

    public Character getCharacterById(String id) {
        CharacterDB character = characterRepository.findOne(id);
        Character player = null;
        if(Optional.ofNullable(character).isPresent()) {
            player = gson.fromJson(character.getCharacterJson(), Character.class);
        }
        return player;
    }

    public List<Character> getCharactersByIds(List<String> ids) {
        List<CharacterDB> characterDBS = new ArrayList<>();
        characterDBS = characterRepository.findAllById(ids);
        if(!characterDBS.isEmpty()) {
            return characterDBS.stream()
                    .map(characterDB -> gson.fromJson(characterDB.getCharacterJson(), Character.class))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
