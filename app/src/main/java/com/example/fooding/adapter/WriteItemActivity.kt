package com.example.fooding.adapter

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.fooding.R

class WriteItemActivity: AppCompatActivity() {
    val get_gallery_image: Int = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_write)

        val imageView = findViewById<ImageView>(R.id.img_foods)
        imageView!!.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*")
            startActivityForResult(intent, get_gallery_image)
        }

        // 저장 버튼!!
        val saveButton = findViewById<Button>(R.id.save_btn)
        saveButton.setOnClickListener() {

        }

    }
}

/*
        var writePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        var readPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)

        if(writePermission == packageManager.PERMISSION_DENIED || readPermission == packageManager.PERMISSION_DENIDED)
*/
