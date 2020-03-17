package com.example.roomdbproducts.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdbproducts.entity.Product

@Dao
interface ProductDao {
    @Insert
    suspend fun insert(product: Product)

    @Query("Select * From product_table ORDER BY id ASC")
    fun getAlphabetizedWords(): LiveData<List<Product>> //live data type cast >>>>working instantly

    @Query("Select * From product_table Where price >= :min And price <= :max")
    fun getProductRange(min: Double, max: Double): LiveData<List<Product>>

    @Query("Select * From product_table Where name= :name ORDER BY id ASC")
    fun getName(name: String): LiveData<List<Product>>

    @Query("Delete From product_table Where id = :id")
    suspend fun deleteId(id:Int)
}