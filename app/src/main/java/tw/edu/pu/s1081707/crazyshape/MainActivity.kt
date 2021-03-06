package tw.edu.pu.s1081707.crazyshape

import android.content.Intent
import android.os.Build.VERSION_CODES.N
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import kotlinx.android.synthetic.main.activity_main.*

@GlideModule
public final class MyAppGlideModule : AppGlideModule()


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        var X: Int = (1..4).random()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgNext.setOnClickListener(this)  //監聽

        Toast.makeText(baseContext, "作者：黃宥明", Toast.LENGTH_LONG).show()

        val img: ImageView = findViewById(R.id.imgTitle)
        GlideApp.with(this)
            .load(R.drawable.cover)
            .override(800, 600)
            .into(img)

        imgNext.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(p0: View?): Boolean {
                intent = Intent(this@MainActivity, GameActivity::class.java)
                startActivity(intent)
                return true

            }
        })
    }

    override fun onClick(v: View?) {
        var X: Int = (1..4).random()
        if(X==1){
            imgNext.setImageResource(R.drawable.circle)
        }else if(X==2){
            imgNext.setImageResource(R.drawable.square)
        }else if(X==3){
            imgNext.setImageResource(R.drawable.star)
        }else{
            imgNext.setImageResource(R.drawable.triangle)
        }
    }
}