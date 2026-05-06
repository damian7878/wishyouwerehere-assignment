package com.damian.wishyouwerehere

import android.os.Parcel
import android.os.Parcelable

data class Location(
    val name: String,
    val place: String,
    val lastVisit: String,
    val rating: Float,
    val imageResId: Int
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readFloat(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(place)
        parcel.writeString(lastVisit)
        parcel.writeFloat(rating)
        parcel.writeInt(imageResId)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Location> {
        override fun createFromParcel(parcel: Parcel) = Location(parcel)
        override fun newArray(size: Int) = arrayOfNulls<Location?>(size)
    }
}