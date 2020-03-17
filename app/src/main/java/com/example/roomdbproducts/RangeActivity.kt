package com.example.roomdbproducts

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_add_product.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_range.*

class RangeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_range)
        btn_ok.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(edt_min.text) || TextUtils.isEmpty(edt_max.text)) {
                edt_min.setError("Id Require")
                edt_max.setError("Name Require")
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val min: String = edt_min.text.toString()
                val max: String = edt_max.text.toString()
                var product: Array<String> = arrayOf(min, max)

                replyIntent.putExtra(EXTRA_REPLY, product)
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