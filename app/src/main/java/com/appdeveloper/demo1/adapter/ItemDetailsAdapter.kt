package com.appdeveloper.demo1.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.appdeveloper.demo1.ItemDetailActivity
import com.appdeveloper.demo1.Items
import com.appdeveloper.demo1.R
import com.squareup.picasso.Picasso

class ItemDetailsAdapter(private val itemList : ArrayList<Items>) :
    RecyclerView.Adapter<ItemDetailsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: AppCompatTextView
        val price: AppCompatTextView
        val rating: AppCompatTextView
        val isCouponApp: AppCompatTextView
        val image: AppCompatImageView


        init {
            // Define click listener for the ViewHolder's View
            name = view.findViewById(R.id.tvItemName)
            price = view.findViewById(R.id.tvPrice)
            rating = view.findViewById(R.id.tvRating)
            isCouponApp = view.findViewById(R.id.tvCoupon)
            image = view.findViewById(R.id.tvItemImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_item_details, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.name.text = itemList[position].name
        holder.price.text = itemList[position].price.toString()
        holder.rating.text = itemList[position].rating.toString()
        holder.isCouponApp.text = itemList[position].isCouponApplicable.toString()

        Picasso.get()
            .load(itemList[position].image)
            .placeholder(R.drawable.loading)
            .error(R.drawable.loading)
            .into(holder.image);

        val item = itemList[position]
        holder.itemView.setOnClickListener {
            val context = it.context
            val detailIntent = Intent(context, ItemDetailActivity::class.java).apply {
                putExtra("itemName", item.name)
                putExtra("itemImage", item.image)
                putExtra("itemPrice", item.price)
                putExtra("itemRating", item.rating)
                putExtra("itemCoupon", item.isCouponApplicable)
            }
            context.startActivity(detailIntent)
        }
    }
}