import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.fooding.R
import adapter.MainListAdapter
import adapter.MainListData

class MainActivity : AppCompatActivity() {

    private lateinit var myAdapter: MainListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDatas = mutableListOf<MainListData>()
        myDatas.add(
                MainListData(
                        findViewById<ImageView>(R.id.img_foods),
                        "스타벅스",
                        "아이스아메리카노",
                        "5000원",
                        "비싸요 ㅠㅠ"

                )
        )

        myAdapter.data = myDatas
        myAdapter.notifyDataSetChanged()



    }
}