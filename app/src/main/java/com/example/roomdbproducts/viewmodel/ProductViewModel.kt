package com.example.roomdbproducts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdbproducts.database.ProductDB
import com.example.roomdbproducts.entity.Product
import com.example.roomdbproducts.repository.ProductRepo

import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ProductRepo
    val allProduts: LiveData<List<Product>>
    lateinit var getRange:LiveData<List<Product>>
    lateinit var getNameA:LiveData<List<Product>>


    init {
        val productDao = ProductDB.getDatabase(application).productDao()
        repository = ProductRepo(productDao)
        allProduts = repository.allProduct
    }


    fun insert(product: Product) = viewModelScope.launch {
        repository.insert(product)
    }
    fun getProductRange(min:Double,max:Double) = viewModelScope.launch {
        getRange=repository.getProductRange(min,max)
    }
    fun getName(name:String) = viewModelScope.launch {
        getNameA = repository.getName(name)
    }
    fun deleteId(id:Int)=viewModelScope.launch {
        repository.deleteId(id)
    }

//    fun delete()=viewModelScope.launch {
//        repository.deleteAll()
//    }

}