package com.example.roomdbproducts

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.roomdbproducts.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.activity_add_product.*

class AddProductActivity : AppCompatActivity() {
    private lateinit var productViewModel: ProductViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)
        btn_save.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(edt_txt.text) || TextUtils.isEmpty(edt_name.text) || TextUtils.isEmpty(
                    edt_price.text
                )
                || TextUtils.isEmpty(edt_quantity.text)
            ) {
                edt_txt.setError("Id Require")
                edt_name.setError("Name Require")
                edt_price.setError("Price Require")
                edt_quantity.setError("Qty Require")
                Toast.makeText(
                    applicationContext,
                    "Jezz just put the Damn product",
                    Toast.LENGTH_LONG
                )
                    .show()
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val id: String = edt_txt.text.toString()
                val name: String = edt_name.text.toString()
                val price: String = edt_price.text.toString()
                val quantity: String = edt_quantity.text.toString()
//                val list: ArrayList<String> = ArrayList()
//                list.add(id)
//                list.add(name)
//                list.add(price)
//                list.add(quantity)
                var product: Array<String> = arrayOf(id,name,price,quantity)

                replyIntent.putExtra(EXTRA_REPLY, product)

//
//
                setResult(Activity.RESULT_OK, replyIntent)
                finish()
            }
        }


    }
    companion object {
        const val EXTRA_REPLY = "REPLY_DATA"
//        const val EXTRA_REPLY1 = "REPLY_DATA"
//        const val EXTRA_REPLY2 = "REPLY_DATA"
//        const val EXTRA_REPLY3 = "REPLY_DATA"
    }
}

