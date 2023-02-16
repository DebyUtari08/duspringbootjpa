package com.juaracoding.duspringbootjpa.service;
/*
Created By IntelliJ IDEA 2022.3.2 (Community Edition)
Build #IC-223.8617.56, built on January 26, 2023
@Author user a.k.a. Deby Utari
Java Developer
Created on 14/02/2023 18.37
@Last Modified 14/02/2023 18.37
Version 1.0
*/

         import com.juaracoding.duspringbootjpa.handler.ResourceNotFoundException;
         import com.juaracoding.duspringbootjpa.model.CategoryProduct;
         import com.juaracoding.duspringbootjpa.repo.CategoryProductRepo;
         import org.springframework.beans.factory.annotation.Autowired;
         import org.springframework.data.domain.Page;
         import org.springframework.data.domain.Pageable;
         import org.springframework.stereotype.Service;
         import org.springframework.transaction.annotation.Transactional;

         import java.sql.SQLException;
         import java.util.Date;
         import java.util.List;
         import java.util.Optional;


@Service
@Transactional
public class CategoryProductService {



    private CategoryProductRepo categoryProductRepo;


    @Autowired
    public CategoryProductService(CategoryProductRepo categoryProductRepo) {
        this.categoryProductRepo = categoryProductRepo;
    }


    public void saveDataCategory(CategoryProduct categoryProduct){

        categoryProductRepo.save(categoryProduct);
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveAllCategory(List<CategoryProduct> listCategoryProduct){
        categoryProductRepo.saveAll(listCategoryProduct);
    }



    @Transactional(rollbackFor = Exception.class)
    public void updateCategory(CategoryProduct categoryProduct,Long id) throws  Exception
    {
        CategoryProduct cProduct = categoryProductRepo.findById(id).orElseThrow (
                ()->  new ResourceNotFoundException("Data tidak ditemukan")
        );

        /*
            SELECT * FROM MstCategoryProduct WHERE IDCategoryProduct = ?
         */
        if(cProduct!=null){
            cProduct.setNameCategoryProduct(categoryProduct.getNameCategoryProduct());
            cProduct.setModifiedBy(categoryProduct.getModifiedBy());
            cProduct.setModifiedDate(new Date());
            cProduct.setStrDescCategoryProduct(categoryProduct.getStrDescCategoryProduct());
        }

    }

    public List<CategoryProduct> findAllCategory()
    {
        return categoryProductRepo.findAll();
        /*
            SELECT * FROM MstCategoryProduct
         */
    }
    public Page<CategoryProduct> findAllCategoryByPage(Pageable pageable)
    {
        return categoryProductRepo.findAll(pageable);
        /*
            SELECT * FROM MstCategoryProduct Page = ? , Sort = ? , Record = ?

            totalRecord = 100
            page = 0
            Record = 10
            data balikan = dari index ke 0 s.d index ke 9

            page = 1
            record = 10
            data balikan = dari index 10 s.d index 19

            page = 2
            record = 10
            data balikan = dari index 20 s.d index 19

         */
    }

    public Optional<CategoryProduct> findById(Long id)
    {
        return categoryProductRepo.findById(id);

        /*
            SELECT * FROM MstCategoryProduct WHERE IDCategoryProduct = ?
         */
    }



}