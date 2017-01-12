package com.playground.character;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/character")
@Slf4j
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping(value = "/find")
    public Character findCharacterById(
            @RequestParam String id
    ) {
        return characterService.getCharacterById(id);
    }

}
