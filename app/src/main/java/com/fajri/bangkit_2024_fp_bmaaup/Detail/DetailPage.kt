package com.fajri.bangkit_2024_fp_bmaaup.Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fajri.bangkit_2024_fp_bmaaup.R

class DetailPage : AppCompatActivity() {
    companion object {
        const val EXTRA_NAME = "extra_name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)
    }
}