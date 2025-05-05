package com.starter.backend.controllers;

import com.starter.backend.dtos.CatDto;
import com.starter.backend.models.Cat;
import com.starter.backend.services.CatService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<Cat> getALlCats(){
        return this.catService.getAllCats();
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "cat id")
    public Cat getCat(@ApiParam(value = "id value for a cat you are looking for",required = true)
                      @PathVariable UUID  id){
        return this.catService.getCat(id);
    }
    @PostMapping
    public Cat addCat(@RequestBody CatDto cat){
        return this.catService.addCat(cat);
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete cat",notes = "Delete cat by id")
    public ResponseEntity<?> deleteCat(@PathVariable UUID id){
        return this.catService.deleteCat(id);
    }
    @PutMapping("/{id}")
    @ApiOperation(value = "update cat",notes = "update cat by id")
    public Cat updateCat(@RequestBody CatDto cat,@PathVariable UUID id){
        return this.catService.updateCat(cat,id);
    }
}
