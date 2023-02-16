package com.juaracoding.duspringbootjpa.service;/*
Created By IntelliJ IDEA 2022.3.2 (Community Edition)
Build #IC-223.8617.56, built on January 26, 2023
@Author user a.k.a. Deby Utari
Java Developer
Created on 14/02/2023 22.05
@Last Modified 14/02/2023 22.05
Version 1.0
*/
import com.juaracoding.duspringbootjpa.model.Test;
import com.juaracoding.duspringbootjpa.repo.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

    @Service
    @Transactional
    public class TestServices {

        private TestRepo testRepo;


        @Autowired
        public TestServices(TestRepo testRepo) {
            this.testRepo = testRepo;
        }


        public void saveAllTest(List<Test> ls){

            testRepo.saveAll(ls);
        }
    }
