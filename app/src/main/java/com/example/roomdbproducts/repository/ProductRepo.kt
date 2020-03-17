package com.example.roomdbproducts.repository

import androidx.lifecycle.LiveData
import com.example.roomdbproducts.dao.ProductDao
import com.example.roomdbproducts.entity.Product

class ProductRepo(private val productDao: ProductDao) {
    val allProduct: LiveData<List<Product>> =
        productDao.getAlphabetizedWords()//case sensitive ware space

    suspend fun insert(product: Product) {
        productDao.insert(product)
    }

    suspend fun deleteId(id:Int){
        productDao.deleteId(id)
    }
    //    val rangeProduct: LiveData<List<Product>> =
//        productDao.getProductRange()
    suspend fun getProductRange(min: Double, max: Double): LiveData<List<Product>> =
        productDao.getProductRange(min, max)

    suspend fun getName(name: String): LiveData<List<Product>> = productDao.getName(name)

//    suspend fun deleteAll() {
//        productDao.deleteAll()
//    }
}