package com.example.roomdbproducts

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_delete.*
import kotlinx.android.synthetic.main.activity_name.*

class DeleteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)
        btn_preceed_delete.setOnClickListener {
            var replyIntent = Intent()
            if (TextUtils.isEmpty(edt_delete.text)) {
                edt_delete.setError("Id Require")

                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                var deId: String = edt_delete.text.toString()
                replyIntent.putExtra(NameActivity.EXTRA_REPLY, deId)
                setResult(Activity.RESULT_OK, replyIntent)
                finish()
            }
        }
    }
    companion object {
        const val EXTRA_REPLY = "REPLY_DATA"
    }

}

