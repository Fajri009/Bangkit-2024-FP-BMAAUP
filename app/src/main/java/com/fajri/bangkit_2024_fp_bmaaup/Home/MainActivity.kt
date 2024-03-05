package com.fajri.bangkit_2024_fp_bmaaup.Home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fajri.bangkit_2024_fp_bmaaup.About.AboutPage
import com.fajri.bangkit_2024_fp_bmaaup.Detail.DetailPage
import com.fajri.bangkit_2024_fp_bmaaup.Member
import com.fajri.bangkit_2024_fp_bmaaup.R

class MainActivity : AppCompatActivity() {
    private lateinit var ivProfile: ImageView
    private lateinit var rvMember: RecyclerView
    private var list = ArrayList<Member>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivProfile = findViewById(R.id.iv_profile)
        rvMember = findViewById(R.id.rv_list_member)
        rvMember.setHasFixedSize(true)

        GoToAboutPage()
        list.addAll(getListMember())
        showRecyclerList()
    }

    private fun GoToAboutPage() {
        ivProfile.setOnClickListener {
            val intentAbout = Intent(this, AboutPage::class.java)
            startActivity(intentAbout)
        }
    }

    private fun getListMember(): ArrayList<Member> {
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataNama = resources.getStringArray(R.array.data_nama)
        val dataGenerasi = resources.getIntArray(R.array.data_generasi)
        val dataTglLahir = resources.getStringArray(R.array.data_tgl_lahir)
        val dataGolDarah = resources.getStringArray(R.array.data_golongan_darah)
        val dataTinggiBadan = resources.getStringArray(R.array.data_tinggi_badan)
        val dataNamaPanggilan = resources.getStringArray(R.array.data_nama_panggilan)
        val dataIg = resources.getStringArray(R.array.data_instagram)
        val dataTwitter = resources.getStringArray(R.array.data_twitter)

        val listMember = ArrayList<Member>()

        for (i in dataNama.indices) {
            val member = Member(dataPhoto.getResourceId(i, -1), dataNama[i], dataGenerasi[i], dataTglLahir[i], dataGolDarah[i], dataTinggiBadan[i], dataNamaPanggilan[i], dataIg[i], dataTwitter[i])
            listMember.add(member)
        }

        return listMember
    }

    private fun showSelectedDetailMember(member: Member) {
        val intentDetail = Intent(this, DetailPage::class.java)
        intentDetail.putExtra(DetailPage.EXTRA_NAME, member)
        startActivity(intentDetail)
    }

    private fun showRecyclerList() {
        rvMember.layoutManager = LinearLayoutManager(this)
        val listMemberAdapter = ListMemberAdapter(list)
        rvMember.adapter = listMemberAdapter

        listMemberAdapter.setOnItemClickCallBack(object: ListMemberAdapter.OnItemClickCallBack {
            override fun onItemClicked(data: Member) {
                showSelectedDetailMember(data)
            }
        })
    }
}