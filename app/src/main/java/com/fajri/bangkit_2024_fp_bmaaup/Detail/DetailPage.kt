package com.fajri.bangkit_2024_fp_bmaaup.Detail

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fajri.bangkit_2024_fp_bmaaup.About.ListDetailMemberAdapter
import com.fajri.bangkit_2024_fp_bmaaup.Home.ListMemberAdapter
import com.fajri.bangkit_2024_fp_bmaaup.Home.MainActivity
import com.fajri.bangkit_2024_fp_bmaaup.Member
import com.fajri.bangkit_2024_fp_bmaaup.R

class DetailPage : AppCompatActivity() {
    private lateinit var ivBack: ImageView

    private lateinit var ivFoto: ImageView
    private lateinit var tvNama: TextView
    private lateinit var tvGenerasi: TextView
    private lateinit var tvTglLahir: TextView
    private lateinit var tvGolonganDarah: TextView
    private lateinit var tvTinggiBadan: TextView
    private lateinit var tvNamaPanggilan: TextView
    private lateinit var tvIg: TextView
    private lateinit var tvTwitter: TextView

    private lateinit var rvMember: RecyclerView
    private var list = ArrayList<Member>()

    companion object {
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)

        ivBack = findViewById(R.id.iv_back)

        ivFoto = findViewById(R.id.iv_foto)
        tvNama = findViewById(R.id.tv_nama_member)
        tvGenerasi = findViewById(R.id.tv_generasi_member)
        tvTglLahir = findViewById(R.id.tv_tgl_lahir_member)
        tvGolonganDarah = findViewById(R.id.tv_gol_darah_member)
        tvTinggiBadan = findViewById(R.id.tv_tinggi_badan_member)
        tvNamaPanggilan = findViewById(R.id.tv_nama_panggilan_member)
        tvIg = findViewById(R.id.tv_ig_member)
        tvTwitter = findViewById(R.id.tv_twitter_member)

        rvMember = findViewById(R.id.rv_member_column)

        GoToBackPage()

        val member =
            if (Build.VERSION.SDK_INT >= 33) {
                intent.getParcelableExtra<Member>(EXTRA_NAME, Member::class.java)
            } else {
                @Suppress("DEPRECATION")
                intent.getParcelableExtra<Member>(EXTRA_NAME)
            }

        GetData(member)
        list.addAll(getListMember())
        showRecyclerList()
    }

    private fun GoToBackPage() {
        ivBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun GetData(member: Member?) {
        if (member != null) {
            ivFoto.setImageResource(member.photo)
            tvNama.text = member.nama
            tvGenerasi.text = member.generasi.toString()
            tvTglLahir.text = member.tglLahir
            tvGolonganDarah.text = member.golDarah
            tvTinggiBadan.text = member.tinggiBadan
            tvNamaPanggilan.text = member.namaPanggilan
            tvIg.text = member.ig
            tvTwitter.text = member.twitter
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
        rvMember.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val listMemberAdapter = ListDetailMemberAdapter(list)
        rvMember.adapter = listMemberAdapter

        listMemberAdapter.setOnItemClickCallBack(object: ListDetailMemberAdapter.OnItemClickCallBack {
            override fun onItemClicked(data: Member) {
                showSelectedDetailMember(data)
            }
        })
    }
}