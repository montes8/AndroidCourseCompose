package com.gb.vale.androidcoursecompose.model

import android.os.Parcelable
import com.gb.vale.androidcoursecompose.utils.EMPTY
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var name: String = EMPTY,
    var token: String = EMPTY
):Parcelable