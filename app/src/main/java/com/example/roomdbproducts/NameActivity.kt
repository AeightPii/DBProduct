package com.example.roomdbproducts

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_name.*
import kotlinx.android.synthetic.main.activity_range.*

class NameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        btn_proceed.setOnClickListener {
            var replyIntent = Intent()
            if (TextUtils.isEmpty(txt_get_name.text)) {
                txt_get_name.setError("Id Require")

                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                var name:String=txt_get_name.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, name)
                setResult(Activity.RESULT_OK, replyIntent)
                finish()
            }
        }
    }

    companion object {
        const val EXTRA_REPLY = "REPLY_DATA"
    }
}

