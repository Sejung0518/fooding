package com.example.fooding.adapter

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.fooding.R
import java.util.jar.Manifest

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

    }

/*
        var writePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        var readPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)

        if(writePermission == packageManager.PERMISSION_DENIED || readPermission == packageManager.PERMISSION_DENIDED)
*/

}