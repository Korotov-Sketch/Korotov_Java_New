package com.project.things.services;

import com.project.things.dao.RelatedProductsRepository;
import com.project.things.entities.RelatedProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RelatedProductsService {

    @Autowired
    RelatedProductsRepository repo;


    public RelatedProducts createProduct(String name, String description){
        RelatedProducts relatedProducts = new RelatedProducts();
        relatedProducts.setName(name);
        relatedProducts.setDescription(description);

        return repo.save(relatedProducts);
    }

    public RelatedProducts getProductById(Integer id){
        return repo.findById(id).get();
    }
    public List<RelatedProducts> getAllProducts(){
        return repo.findAll();
    }
    public RelatedProducts getProductByName(String name){
        return repo.findAll().stream().filter(elem -> elem.getName() == name).findFirst().get();
    }
    public RelatedProducts updateProduct(Integer product_id, String newName, String newDescription){
        RelatedProducts relatedProducts = repo.findById(product_id).get();
        relatedProducts.setName(newName);
        relatedProducts.setDescription(newDescription);
        return repo.save(relatedProducts);
    }
    public void deleteProduct(Integer item_id){
        repo.deleteById(item_id);
    }

}
