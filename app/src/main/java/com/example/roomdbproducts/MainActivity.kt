package com.example.roomdbproducts

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabase.adapter.ProductAdapter
import com.example.roomdbproducts.entity.Product
import com.example.roomdbproducts.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val AddWordActivityCode = 1
    private val RangeActivityCode = 2
    private val SearchActivityCode = 3
    private val DeleteActivityCode = 4

    private lateinit var productViewModel: ProductViewModel
    private val productAdapter = ProductAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_add.setOnClickListener {
            val intent = Intent(this@MainActivity, AddProductActivity::class.java)
            startActivityForResult(intent, AddWordActivityCode)
        }
        btn_range.setOnClickListener {
            val intent = Intent(this@MainActivity, RangeActivity::class.java)
            startActivityForResult(intent, RangeActivityCode)
        }
        btn_search.setOnClickListener {
            val intent = Intent(this@MainActivity, NameActivity::class.java)
            startActivityForResult(intent, SearchActivityCode)
        }
        btn_delete.setOnClickListener {
            val intent = Intent(this@MainActivity, DeleteActivity::class.java)
            startActivityForResult(intent, DeleteActivityCode)
        }
        //  val productAdapter = ProductAdapter()
        recProduct.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = productAdapter
        }
        //................
        productViewModel = ViewModelProvider(this)
            .get(ProductViewModel::class.java)
        btn_getall.setOnClickListener {
            productViewModel.allProduts.observe(this,
                Observer { products ->
                    //word refers above allwords
                    products?.let {
                        productAdapter.setWords(it)
                    }
                })
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == AddWordActivityCode && resultCode == Activity.RESULT_OK) {

            var productArray = data?.getStringArrayExtra(AddProductActivity.EXTRA_REPLY)
            var product = Product()
            product.id = productArray?.get(0)?.toInt()
            product.name = productArray?.get(1)
            product.price = productArray?.get(2)?.toDouble()
            product.quantity = productArray?.get(3)?.toInt()
            productViewModel.insert(product)
            val w: String? = data?.getStringExtra(AddProductActivity.EXTRA_REPLY)
            Log.d("word main>>>>", "$w")
//            productViewModel.allProduts.observe(this,
//                Observer { products ->
//                    //word refers above allwords
//                    products?.let {
//                        productAdapter.setWords(it)
//                    }
//                })

        }

        if (requestCode == RangeActivityCode && resultCode == Activity.RESULT_OK) {
            var productArray = data?.getStringArrayExtra(RangeActivity.EXTRA_REPLY)

            val min = productArray!![0].toDouble()
            val max = productArray!![1].toDouble()
            productViewModel.getProductRange(min, max)

            productViewModel.getRange.observe(this,
                Observer { products ->
                    //word refers above allwords
                    products?.let {
                        productAdapter.setWords(it)
                    }
                })
        }

        if (requestCode == SearchActivityCode && resultCode == Activity.RESULT_OK) {
            var a = data?.getStringExtra(NameActivity.EXTRA_REPLY)
            productViewModel.getName(a.toString())
            productViewModel.getNameA.observe(
                this, Observer { products ->
                    //word refers above allwords
                    products?.let {
                        productAdapter.setWords(it)
                    }
                }
            )
        }

        if (requestCode == DeleteActivityCode && resultCode == Activity.RESULT_OK) {
            var deId = data?.getStringExtra(DeleteActivity.EXTRA_REPLY)
            productViewModel.deleteId(deId!!.toInt())
            productViewModel.allProduts.observe(
                this, Observer { products ->
                    //word refers above allwords
                    products?.let {
                        productAdapter.setWords(it)
                    }
                }
            )
        }
    }
}




