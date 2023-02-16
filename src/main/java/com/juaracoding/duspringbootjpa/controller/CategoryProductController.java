package com.juaracoding.duspringbootjpa.controller;/*
Created By IntelliJ IDEA 2022.3.2 (Community Edition)
Build #IC-223.8617.56, built on January 26, 2023
@Author user a.k.a. Deby Utari
Java Developer
Created on 14/02/2023 18.16
@Last Modified 14/02/2023 18.16
Version 1.0
*/
import com.juaracoding.duspringbootjpa.handler.ResponseHandler;
import com.juaracoding.duspringbootjpa.model.CategoryProduct;
import com.juaracoding.duspringbootjpa.service.CategoryProductService;
import com.juaracoding.duspringbootjpa.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/mgmnt")
public class CategoryProductController {


    private CategoryProductService categoryProductService;

    @Autowired
    public CategoryProductController(CategoryProductService categoryProductService) {
        this.categoryProductService = categoryProductService;
    }

    @PostMapping("/v1/s")
    public ResponseEntity<Object> saveCategory(@Valid
                                               @RequestBody CategoryProduct categoryProduct
    ){

        categoryProductService.saveDataCategory(categoryProduct);

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,null,null,null);
        //FI01001 --> F = FAILED , I = INSERT, 01 = MODUL, 001 = LENGTH NAME MAX 40
        //FI01002 --> F = FAILED , I = INSERT, 01 = MODUL, 002 = LENGTH DESC MAX 500
        //FI01003 --> F = FAILED , I = INSERT, 01 = MODUL, 003 = DATETIME FORMAT
        //SI01001 --> S = SUCCESS , I = INSERT , 01 = MODUL,

    }

    @PostMapping("/v1/sl")
    public ResponseEntity<Object> saveCategoryList(@Valid
                                                   @RequestBody List<CategoryProduct> listCategoryProduct
    ){

        categoryProductService.saveAllCategory(listCategoryProduct);

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);

    }

    @PutMapping("/v1/sl/{id}")
    public ResponseEntity<Object> updateCategoryById(@Valid
                                                     @RequestBody CategoryProduct categoryProduct,
                                                     @PathVariable Long id
    ) throws Exception {

        categoryProductService.updateCategory(categoryProduct,id);

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,null,null,null);
    }

    @GetMapping("/v1/f")
    public ResponseEntity<Object> findAll(){

        List<CategoryProduct> ls = categoryProductService.findAllCategory();

        if(ls.size()==0)
        {
            return new ResponseHandler().
                    generateResponse(ConstantMessage.WARNING_DATA_EMPTY,
                            HttpStatus.NOT_FOUND,
                            categoryProductService.findAllCategory(),
                            null,
                            null);
        }

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,
                        HttpStatus.OK,
                        ls,
                        null,
                        null);


    }

    @GetMapping("/v1/fp/{size}/{page}/{sort}")
    public ResponseEntity<Object> findAllPagination(
            @PathVariable("size") Integer sizez,
            @PathVariable("page") Integer pagez,
            @PathVariable("sort") String sortz
    ){

        Pageable pageable = null;
        if(sortz.equalsIgnoreCase("desc"))
        {
            pageable = PageRequest.of(pagez,sizez, Sort.by("id").descending());
        }
        else
        {
            pageable = PageRequest.of(pagez,sizez);

        }
//        Page<CategoryProduct> page = categoryProductService.findAllCategoryByPage(pageable);
//
//        if(page.)
//        {
//            return new ResponseHandler().
//                    generateResponse(ConstantMessage.WARNING_DATA_EMPTY,
//                            HttpStatus.NOT_FOUND,
//                            categoryProductService.findAllCategory(),
//                            null,
//                            null);
//        }

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,
                        HttpStatus.OK,
                        categoryProductService.findAllCategoryByPage(pageable),
                        null,
                        null);


    }

}