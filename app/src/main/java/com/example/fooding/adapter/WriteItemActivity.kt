package com.example.fooding.adapter

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.fooding.R
import com.example.fooding.data.ListData
import com.example.fooding.data.ListDatabase
import java.lang.Exception

class WriteItemActivity : AppCompatActivity() {

    private var listDB: ListDatabase? = null
    var homeBtn : Button = findViewById<Button>(R.id.home_btn)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_write)

        listDB = ListDatabase.getInstance(this)

        // 사용자에게 갤러리 이미지 받기
        val imageView = findViewById<ImageView>(R.id.img_foods)
        imageView!!.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 0)
        }

        // 사용자에게 랭킹 받기
        val edit_ranking = findViewById<RatingBar>(R.id.edit_ranking)
        edit_ranking.setOnRatingBarChangeListener(){ ratingBar, rating, fromUser ->
            edit_ranking.rating = rating
        }

        // 홈 화면으로 돌아가기 (홈버튼)
        homeBtn.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }



    }

    // ImgView에 사진 불러오기
    private var selectedPhotoUri: Uri? = null

    // Category 변수 선언
    private var categoryImgae = findViewById<ImageView>(R.id.edi_category)

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Category에 사진 불러오기
        categoryImgae.setOnClickListener{

        }

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

/*
        var writePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        var readPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)

        if(writePermission == packageManager.PERMISSION_DENIED || readPermission == packageManager.PERMISSION_DENIDED)
*/
