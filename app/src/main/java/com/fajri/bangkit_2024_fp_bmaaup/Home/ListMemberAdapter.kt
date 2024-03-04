package com.fajri.bangkit_2024_fp_bmaaup.Home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fajri.bangkit_2024_fp_bmaaup.Member
import com.fajri.bangkit_2024_fp_bmaaup.R

class ListMemberAdapter(
    private val listMember: ArrayList<Member>
): RecyclerView.Adapter<ListMemberAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallBack: OnItemClickCallBack

    fun setOnItemClickCallBack(onItemClickCallBack: OnItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack
    }

    interface OnItemClickCallBack {
        fun onItemClicked(data: Member)
    }

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.iv_foto_member)
        val tvNama: TextView = itemView.findViewById(R.id.tv_nama_member)
        val tvGenerasi: TextView = itemView.findViewById(R.id.tv_generasi_member)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list_member, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (photo, nama, generasi) = listMember[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvNama.text = nama
        holder.tvGenerasi.text = generasi.toString()

        holder.itemView.setOnClickListener {
            onItemClickCallBack.onItemClicked(listMember[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listMember.size
}