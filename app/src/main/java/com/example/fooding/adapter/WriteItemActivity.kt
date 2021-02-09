package com.example.fooding.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.bumptech.glide.GenericTransitionOptions.with
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.with
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.with
import com.example.fooding.R
import com.example.fooding.data.ListData
import com.example.fooding.data.ListDatabase
import com.squareup.picasso.Picasso
import java.lang.Exception

class WriteItemActivity : AppCompatActivity() {

    private var listDB: ListDatabase? = null

    // Category 변수 선언
    private lateinit var categoryImage: ImageView
    private lateinit var homBtn: Button

    // ImgView에 사진 불러오기
    private var selectedPhotoUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_write)


        listDB = ListDatabase.getInstance(this)
        val homeBtn = findViewById<Button>(R.id.home_btn)

        // 사용자에게 갤러리 이미지 받기
        val imageView = findViewById<ImageView>(R.id.img_foods)
        imageView!!.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 0)
        }

        // 사용자에게 랭킹 받기
        val edit_ranking = findViewById<RatingBar>(R.id.edit_ranking)
        edit_ranking.setOnRatingBarChangeListener() { ratingBar, rating, fromUser ->
            edit_ranking.rating = rating
        }

        // 홈 화면으로 돌아가기 (홈버튼)
        homeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

    @SuppressLint("ResourceType")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        /* 새로운 list 객체를 생성, id 이외의 값을 지정 후 DB에 추가 */
        val addRunnable = Runnable {
            try {
                // 입력 받을 데이터 선언
                val img_uri = selectedPhotoUri
                val store_txt = findViewById<EditText>(R.id.edit_name_stores).text.toString()
                val food_txt = findViewById<EditText>(R.id.edit_name_foods).text.toString()
                val price_txt = findViewById<EditText>(R.id.edit_price_foods).text.toString()
                val rank_txt = findViewById<RatingBar>(R.id.edit_ranking).rating
                val contents_txt = findViewById<EditText>(R.id.edit_contents_foods).text.toString()

                // 입력 받은 데이터 ListData 추가(=ListDB에 추가하기!)
                val newList = ListData()
                newList.img_foods = img_uri.toString()
                newList.name_stores = store_txt
                newList.name_foods = food_txt
                newList.price_foods = price_txt
                newList.rank_foods = rank_txt
                newList.contents_foods = contents_txt
                listDB?.listDao()?.insert(newList)

            } catch (e: Exception) {
                Log.d("tag", "Error- $e")
            }
        }

        if (requestCode == 0 && resultCode == Activity.RESULT_OK && data != null) {
            // proceed and check what the selected image was...

            selectedPhotoUri = data.data

            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, selectedPhotoUri)

            val img = findViewById<ImageView>(R.id.img_foods)

            img.setImageBitmap(bitmap)
            img.alpha = 1f

        }

        // Category에 사진 불러오기
        val categoryImage = findViewById<ImageView>(R.id.edit_category)
        categoryImage.setOnClickListener() {
            val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = inflater.inflate(R.layout.category_popup,null)

            // 팝업 창 크기 조절
            val dm = application.applicationContext.resources.displayMetrics
            val w = (dm.widthPixels*0.9).toInt()
            val h = (dm.widthPixels*0.2).toInt()

            val alertDialog = AlertDialog.Builder(this)
                .setView(findViewById(R.layout.category_popup))
                .create()
            alertDialog.window?.setBackgroundDrawableResource(R.drawable.category_shape)
            alertDialog.window?.attributes?.width = w
            alertDialog.window?.attributes?.height = h
            alertDialog.setView(view)

            // 카테고리1
            alertDialog.setView(view.findViewById<ImageView>(R.id.cat1).setOnClickListener{
                Glide.with(this).load(R.drawable.cat1).into(categoryImage)
                alertDialog.dismiss()
            })

            // 카테고리2
            alertDialog.setView(view.findViewById<ImageView>(R.id.cat2).setOnClickListener{
                Glide.with(this).load(R.drawable.cat2).into(categoryImage)
                alertDialog.dismiss()
            })

            // 카테고리3
            alertDialog.setView(view.findViewById<ImageView>(R.id.cat3).setOnClickListener{
                Glide.with(this).load(R.drawable.cat3).into(categoryImage)
                alertDialog.dismiss()
            })

            // 카테고리4
            alertDialog.setView(view.findViewById<ImageView>(R.id.cat4).setOnClickListener{
                Glide.with(this).load(R.drawable.cat4).into(categoryImage)
                alertDialog.dismiss()
            })

            // 카테고리5
            alertDialog.setView(view.findViewById<ImageView>(R.id.cat5).setOnClickListener{
                Glide.with(this).load(R.drawable.cat5).into(categoryImage)
                alertDialog.dismiss()
            })

            // 카테고리6
            alertDialog.setView(view.findViewById<ImageView>(R.id.cat6).setOnClickListener{
                Glide.with(this).load(R.drawable.cat6).into(categoryImage)
                alertDialog.dismiss()
            })

            // 카테고리7
            alertDialog.setView(view.findViewById<ImageView>(R.id.cat7).setOnClickListener{
                Glide.with(this).load(R.drawable.cat7).into(categoryImage)
                alertDialog.dismiss()
            })

            // 카테고리8
            alertDialog.setView(view.findViewById<ImageView>(R.id.cat8).setOnClickListener{
                Glide.with(this).load(R.drawable.cat8).into(categoryImage)
                alertDialog.dismiss()
            })

            // 카테고리9
            alertDialog.setView(view.findViewById<ImageView>(R.id.cat9).setOnClickListener{
                Glide.with(this).load(R.drawable.cat9).into(categoryImage)
                alertDialog.dismiss()
            })

            // 카테고리10
            alertDialog.setView(view.findViewById<ImageView>(R.id.cat10).setOnClickListener{
                Glide.with(this).load(R.drawable.cat10).into(categoryImage)
                alertDialog.dismiss()
            })

            alertDialog.show()
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

    //삭제버튼(아직 미구현)
    override fun onDestroy() {
        ListDatabase.destroyInstance()
        listDB = null
        super.onDestroy()
    }

}

private fun Any?.setBackgroundDrawable(categoryShape: Int) {

}

private fun AlertDialog.setView(onClickListener: Unit) {

}


/*
        var writePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        var readPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)

        if(writePermission == packageManager.PERMISSION_DENIED || readPermission == packageManager.PERMISSION_DENIDED)
*/
