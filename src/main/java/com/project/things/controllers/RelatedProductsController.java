package com.project.things.controllers;

import com.project.things.entities.RelatedProducts;
import com.project.things.services.RelatedProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RelatedProductsController {

    @Autowired
    private RelatedProductsService relatedProductsService;

    @PostMapping(value = "/createProduct")
    public RelatedProducts createProduct(@RequestParam(required = false, defaultValue = "some description")
                                     String description, @RequestParam(required = false,
            defaultValue = "some name") String name){
        return relatedProductsService.createProduct(name, description);
    }

    @GetMapping(value = "/getProduct/{id}")
    public RelatedProducts getProductById(@PathVariable(value = "id") Integer id){
        return relatedProductsService.getProductById(id);
    }
    @GetMapping(value = "/getAllProducts")
    public List<RelatedProducts> getAllProducts(){
        return relatedProductsService.getAllProducts();
    }

    @PatchMapping(value = "/updateProduct")
    public RelatedProducts updateProduct(@RequestParam Integer id, @RequestParam String newDescription,
                                         @RequestParam String newName){
        return relatedProductsService.updateProduct(id,newName, newDescription);
    }
    @DeleteMapping(value = "/deleteProduct")
    public void deleteProduct(@RequestParam Integer id){
        relatedProductsService.deleteProduct(id);
    }
}
