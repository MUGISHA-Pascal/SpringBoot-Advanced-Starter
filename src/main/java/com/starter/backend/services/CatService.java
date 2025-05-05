package com.starter.backend.services;

import com.starter.backend.dtos.CatDto;
import com.starter.backend.exceptions.ApiRequestException;
import com.starter.backend.exceptions.AppException;
import com.starter.backend.models.Cat;
import com.starter.backend.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CatService {
    private final CatRepository catRepository;
    @Autowired
    public CatService(CatRepository catRepository){
        this.catRepository=catRepository;
    }
    public List<Cat> getAllCats(){
        List<Cat> cats = catRepository.findAll();
        return cats;
    }
    public Cat addCat(CatDto catDto){
        Cat newCat=new Cat(catDto.getName());
        return catRepository.save(newCat);
    }
    public Cat getCat(UUID id){
        Optional<Cat> isCatFound=Optional.ofNullable(catRepository.findById(id).orElseThrow(()->new ApiRequestException("Cat with id "+id+" doesnot exist")));
        return isCatFound.get();
    }
    public ResponseEntity<?> deleteCat(UUID id){
        Optional<Cat> isCatFound= Optional.ofNullable(catRepository.findById(id).orElseThrow(()->new ApiRequestException("cat with id "+id+" doesnot exist")));
        catRepository.delete(isCatFound.get());
        return ResponseEntity.ok().build();
    }
    public Cat updateCat(CatDto catDto,UUID id){
        Cat catExisting = catRepository.findById(id).orElseThrow(()->new ApiRequestException("Cat with Id "+id+" doesnot exist"));
        catExisting.setName(catDto.getName());
        return catRepository.save(catExisting);
    }

}
