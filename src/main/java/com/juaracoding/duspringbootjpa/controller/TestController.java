package com.juaracoding.duspringbootjpa.controller;/*
Created By IntelliJ IDEA 2022.3.2 (Community Edition)
Build #IC-223.8617.56, built on January 26, 2023
@Author user a.k.a. Deby Utari
Java Developer
Created on 15/02/2023 21.02
@Last Modified 15/02/2023 21.02
Version 1.0
*/

import com.juaracoding.duspringbootjpa.handler.ResponseHandler;
import com.juaracoding.duspringbootjpa.model.Test;
import com.juaracoding.duspringbootjpa.service.TestServices;
import com.juaracoding.duspringbootjpa.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tests")
public class TestController {


    private TestServices testServices;

    @Autowired
    public TestController(TestServices testServices) {
        this.testServices = testServices;
    }

    @PostMapping("/v1/s")
    public ResponseEntity<Object> saveAll(
            @RequestBody List<Test> listTest
    ){

        testServices.saveAllTest(listTest);

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,null,null,null);

    }
}

