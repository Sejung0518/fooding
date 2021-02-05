package com.example.fooding.adapter

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.fooding.R
import java.util.jar.Manifest

class WriteItemActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_write)

        var imageView = findViewById<ImageView>(R.id.img_foods)
        imageView.setOnClickListener(){

        }
    }

    val gallery = 0
    private fun selectGalary(){
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(Intent.createChooser(intent, "Load Image"), gallery)

/*
        var writePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        var readPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)

        if(writePermission == packageManager.PERMISSION_DENIED || readPermission == packageManager.PERMISSION_DENIDED)
*/
        
    }

    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == gallery){
            if(requestCode == RESULT_OK){
                var dataUri = data?.data
                try{
                    var bitmap:Bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, dataUri)
                    var img_foods = findViewById<ImageView>(R.id.img_foods)
                    img_foods.setImageBitmap(bitmap)
                }catch (e:Exception){
                    Toast.makeText(this, "$e", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, "something wrong with the request code", Toast.LENGTH_SHORT).show()
            }
        }
    }
}