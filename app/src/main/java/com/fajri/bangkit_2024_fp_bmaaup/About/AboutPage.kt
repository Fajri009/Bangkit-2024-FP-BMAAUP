package com.fajri.bangkit_2024_fp_bmaaup.About

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fajri.bangkit_2024_fp_bmaaup.Detail.DetailPage
import com.fajri.bangkit_2024_fp_bmaaup.Home.ListMemberAdapter
import com.fajri.bangkit_2024_fp_bmaaup.Member
import com.fajri.bangkit_2024_fp_bmaaup.R

class AboutPage : AppCompatActivity() {
    private lateinit var ivBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_page)

        ivBack = findViewById(R.id.iv_back)

        GoToBackPage()
    }

    private fun GoToBackPage() {
        ivBack.setOnClickListener {
            finish()
        }
    }
}