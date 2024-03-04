package com.fajri.bangkit_2024_fp_bmaaup

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Member(
    val photo: Int,
    val nama: String,
    val generasi: Int,
    val tglLahir: String
): Parcelable