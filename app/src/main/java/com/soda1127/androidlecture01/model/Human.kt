package com.soda1127.androidlecture01.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

enum class Gender(val type: String) { MAN("남성"), WOMAN("여성") }

@Parcelize
data class Human(val name: String, val age: Int, val gender: Gender): Parcelable