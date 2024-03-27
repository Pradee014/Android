package com.appdeveloper.demo1

import android.os.Parcel
import android.os.Parcelable

data class Items(
    val name: String?,
    val image: String?,
    val price: Double,
    val rating: Double,
    val isCouponApplicable: String?

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(image)
        parcel.writeDouble(price)
        parcel.writeDouble(rating)
        parcel.writeString(isCouponApplicable)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Items> {
        override fun createFromParcel(parcel: Parcel): Items {
            return Items(parcel)
        }

        override fun newArray(size: Int): Array<Items?> {
            return arrayOfNulls(size)
        }
    }
}
