package com.starter.backend.controllers;

import com.starter.backend.models.Cat;
import com.starter.backend.services.CatService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(path = "api/v1/cats")
public class CatController {
    private final CatService catService;
    @Autowired
    public CatController(CatService catService){
        this.catService=catService;
    }
    @GetMapping
    @ApiOperation(value="Get all Cats",notes = "Get all cats ' information",response = Cat.class)
    public List<Cat> getALlCats()
}
