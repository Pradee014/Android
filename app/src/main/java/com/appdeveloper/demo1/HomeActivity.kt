package com.appdeveloper.demo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appdeveloper.demo1.adapter.ItemDetailsAdapter
import com.appdeveloper.demo1.model.reqres.DataX
import com.appdeveloper.demo1.model.reqres.ListResourceResponse

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val home = findViewById<Button>(R.id.home)
        val search = findViewById<Button>(R.id.searc)
        val setting = findViewById<Button>(R.id.settings)


        home.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl,HomeFragment())
                addToBackStack(null)
                commit()
            }
        }

        search.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl,SearchFragment())
                addToBackStack(null)
                commit()
            }
        }

        setting.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl,SettingsFragment())
                addToBackStack(null)
                commit()
            }
        }


        val itemList = arrayListOf<Items>()

        itemList.add(
            Items(
                name = "Dum Biryani",
                image = "https://img.freepik.com/free-photo/gourmet-chicken-biryani-with-steamed-basmati-rice-generated-by-ai_188544-13480.jpg?t=st=1710536175~exp=1710539775~hmac=1b03e4fe9bc96b9052d60dd22fb2405fff112da4fe9ef50decdcfda5645477d1&w=2000",
                price = 15.99,
                rating = 4.6,
                isCouponApplicable = "$2 Offer"
            )
        )
        itemList.add(
            Items(
                name = "Pasta",
                image = "https://img.freepik.com/free-photo/penne-pasta-tomato-sauce-with-chicken-tomatoes-wooden-table_2829-19744.jpg?t=st=1710536289~exp=1710539889~hmac=a8a98ea53c547240e072fd7d786fe1c0545bcbef4919739b8e009577c27dd766&w=1800",
                price = 11.99,
                rating = 4.3,
                isCouponApplicable = "No Coupon"
            )
        )
        itemList.add(
            Items(
                name = "Taco",
                image = "https://img.freepik.com/free-photo/mexican-tacos-with-meat-vegetables-red-onion_2829-8665.jpg?t=st=1710536364~exp=1710539964~hmac=2d4aea87f25b51cc9ea77b4c10159c05b7141b8669b16e52469a8643f5294d6c&w=1800",
                price = 4.99,
                rating = 4.3,
                isCouponApplicable = "No Coupon"
            )
        )
        itemList.add(
            Items(
                name = "Kung Pao Chicken",
                image = "https://img.freepik.com/free-photo/top-view-asian-dish-with-rice-herbs_23-2148694338.jpg?t=st=1710536460~exp=1710540060~hmac=33e5e433f7d762dc8413adfcb80b5a61c466cb18fc8767cbeefbac7096327c9a&w=996",
                price = 14.99,
                rating = 4.3,
                isCouponApplicable = "$3 Offer"
            )
        )
        itemList.add(
            Items(
                name = "Nuggets and fries",
                image = "https://img.freepik.com/free-photo/chicken-finger-sticks-served-with-fries-mayonnaise-ketchup_140725-233.jpg?t=st=1710536778~exp=1710540378~hmac=ba05a8f38865f9694a41f92d1167bcbb74f6da8d54bbb0d21c53d0c6ee93a7a5&w=1060",
                price = 8.99,
                rating = 4.2,
                isCouponApplicable = "No Coupon"
            )
        )
        itemList.add(
            Items(
                name = "Pizza",
                image = "https://img.freepik.com/free-photo/large-mixed-pizza-with-meat_140725-1274.jpg?t=st=1710536885~exp=1710540485~hmac=7d59d6def241a52a7fc11085882b0331a98c3b8c6db25c6e1c7967795ae2f1d4&w=996",
                price = 13.99,
                rating = 4.2,
                isCouponApplicable = "No Coupon"
            )
        )
        itemList.add(
            Items(
                name = "Dum Biryani",
                image = "https://img.freepik.com/free-photo/gourmet-chicken-biryani-with-steamed-basmati-rice-generated-by-ai_188544-13480.jpg?t=st=1710536175~exp=1710539775~hmac=1b03e4fe9bc96b9052d60dd22fb2405fff112da4fe9ef50decdcfda5645477d1&w=2000",
                price = 15.99,
                rating = 4.6,
                isCouponApplicable = "$2 Coupon"
            )
        )
        itemList.add(
            Items(
                name = "Pasta",
                image = "https://img.freepik.com/free-photo/penne-pasta-tomato-sauce-with-chicken-tomatoes-wooden-table_2829-19744.jpg?t=st=1710536289~exp=1710539889~hmac=a8a98ea53c547240e072fd7d786fe1c0545bcbef4919739b8e009577c27dd766&w=1800",
                price = 11.99,
                rating = 4.3,
                isCouponApplicable = "No Coupon"
            )
        )
        itemList.add(
            Items(
                name = "Taco",
                image = "https://img.freepik.com/free-photo/mexican-tacos-with-meat-vegetables-red-onion_2829-8665.jpg?t=st=1710536364~exp=1710539964~hmac=2d4aea87f25b51cc9ea77b4c10159c05b7141b8669b16e52469a8643f5294d6c&w=1800",
                price = 4.99,
                rating = 4.3,
                isCouponApplicable = "No Coupon"
            )
        )
        itemList.add(
            Items(
                name = "Kung Pao Chicken",
                image = "https://img.freepik.com/free-photo/top-view-asian-dish-with-rice-herbs_23-2148694338.jpg?t=st=1710536460~exp=1710540060~hmac=33e5e433f7d762dc8413adfcb80b5a61c466cb18fc8767cbeefbac7096327c9a&w=996",
                price = 14.99,
                rating = 4.3,
                isCouponApplicable = "$3 Coupon"
            )
        )
        itemList.add(
            Items(
                name = "Nuggets and fries",
                image = "https://img.freepik.com/free-photo/chicken-finger-sticks-served-with-fries-mayonnaise-ketchup_140725-233.jpg?t=st=1710536778~exp=1710540378~hmac=ba05a8f38865f9694a41f92d1167bcbb74f6da8d54bbb0d21c53d0c6ee93a7a5&w=1060",
                price = 8.99,
                rating = 4.2,
                isCouponApplicable = "No Coupon"
            )
        )
        itemList.add(
            Items(
                name = "Pizza",
                image = "https://img.freepik.com/free-photo/large-mixed-pizza-with-meat_140725-1274.jpg?t=st=1710536885~exp=1710540485~hmac=7d59d6def241a52a7fc11085882b0331a98c3b8c6db25c6e1c7967795ae2f1d4&w=996",
                price = 13.99,
                rating = 4.2,
                isCouponApplicable = "No Coupon"
            )
        )

//        val recyclerView: RecyclerView = findViewById(R.id.cuisineRecyclerView)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = ItemDetailsAdapter(itemList)

    }


}