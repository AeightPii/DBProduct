package com.example.roomdbproducts.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdbproducts.dao.ProductDao
import com.example.roomdbproducts.entity.Product

@Database(entities = arrayOf(Product::class), version = 1)
abstract class ProductDB : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        //singleton prevents multiple istance of database
        //opening at hte same time
        private var INSTANCE: ProductDB? = null

        fun getDatabase(context: Context):
                ProductDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance//return last statement
            }
            synchronized(this) {
                //immediate creating database
                val instance = Room.databaseBuilder(
                    context,
                    ProductDB::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}