package com.appdeveloper.demo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ItemDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)

        val name = intent.getStringExtra("itemName")
        val image = intent.getStringExtra("itemImage")
        val price = intent.getDoubleExtra("itemPrice", 0.0)
        val rating = intent.getDoubleExtra("itemRating", 0.0)
        val coupon = intent.getStringExtra("itemCoupon")

        findViewById<TextView>(R.id.detailNameTextView).text = name

        Picasso.get().load(image).into(findViewById<ImageView>(R.id.detailImageView))


    }
}