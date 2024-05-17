// ImageDetailActivity.kt
package com.example.pinterest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.pinterest.database.Favorites
import com.example.pinterest.database.PinDB
import com.example.pinterest.databinding.ActivityImageDetailBinding

class ImageDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUrl = intent.getStringExtra("IMAGE_URL")
        val imageName = intent.getStringExtra("IMAGE_NAME")

        imageUrl?.let {
            Glide.with(this)
                .load(it)
                .into(binding.imageView)
        }
        binding.imageTitle.text = imageName

        binding.backButton.setOnClickListener {
            finish()
        }

        val db = PinDB.getDb(this)
        binding.saveButton.setOnClickListener{
            val favorite = Favorites(null,
                binding.imageView.toString(),
                binding.imageTitle.text.toString()
            )
            Thread{
                db.getDao().insertFavorite(favorite)
            }.start()
        }
    }
}
