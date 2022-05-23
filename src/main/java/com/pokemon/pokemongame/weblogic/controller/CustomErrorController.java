package com.pokemon.pokemongame.weblogic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public static String handleError(JsonProcessingException e){

        return e.getMessage();
    }




}
