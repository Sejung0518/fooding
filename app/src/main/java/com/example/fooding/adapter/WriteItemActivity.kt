package com.example.fooding.adapter

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.fooding.R
import com.example.fooding.data.ListData
import com.example.fooding.data.ListDatabase
import java.lang.Exception

class WriteItemActivity: AppCompatActivity() {

    private var listDB: ListDatabase? = null
    val get_gallery_image: Int = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_write)

        val store_txt = findViewById<EditText>(R.id.edit_name_stores).editableText.toString()
        val food_txt = findViewById<EditText>(R.id.edit_name_foods).editableText.toString()
        val price_txt = findViewById<EditText>(R.id.edit_price_foods).editableText.toString()
        val rank_txt = findViewById<EditText>(R.id.edit_ranking).editableText.toString()
        val contents_txt = findViewById<EditText>(R.id.edit_contents_foods).editableText.toString()


       listDB = ListDatabase.getInstance(this)

        /* 새로운 cat 객체를 생성, id 이외의 값을 지정 후 DB에 추가 */
        val addRunnable = Runnable {
           try {
               val newList = ListData()
               newList.name_stores = store_txt
               newList.name_foods = food_txt
               newList.price_foods = price_txt
               newList.rank_foods = rank_txt
               newList.contents_foods = contents_txt
               listDB?.listDao()?.insert(newList)
           } catch (e:Exception){
               Log.d("tag","Error- $e")
           }
        }

        val imageView = findViewById<ImageView>(R.id.img_foods)
        imageView!!.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*")
            startActivityForResult(intent, get_gallery_image)
        }

        // 저장 버튼!!
        val saveButton = findViewById<Button>(R.id.save_btn)
        saveButton.setOnClickListener() {
            val addThread = Thread(addRunnable)
            addThread.start()

            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }

    }

    override fun onDestroy() {
        ListDatabase.destroyInstance()
        listDB = null
        super.onDestroy()
    }
}

/*
        var writePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        var readPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)

        if(writePermission == packageManager.PERMISSION_DENIED || readPermission == packageManager.PERMISSION_DENIDED)
*/
