package com.juaracoding.duspringbootjpa.model;/*
Created By IntelliJ IDEA 2022.3.2 (Community Edition)
Build #IC-223.8617.56, built on January 26, 2023
@Author user a.k.a. Deby Utari
Java Developer
Created on 14/02/2023 22.00
@Last Modified 14/02/2023 22.00
Version 1.0
*/
import javax.persistence.*;
import java.time.LocalDate;


    @Entity
    @Table(name = "MstTest")
    public class Test {

        @Id
        @Column(name = "IDTest")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "DateTest" , nullable = false)
        private LocalDate dateTest;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public LocalDate getDateTest() {
            return dateTest;
        }

        public void setDateTest(LocalDate dateTest) {
            this.dateTest = dateTest;
        }
    }
