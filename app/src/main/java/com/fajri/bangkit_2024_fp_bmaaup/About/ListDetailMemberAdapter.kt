package com.fajri.bangkit_2024_fp_bmaaup.About

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fajri.bangkit_2024_fp_bmaaup.Member
import com.fajri.bangkit_2024_fp_bmaaup.R

class ListDetailMemberAdapter(
    private val listMember: ArrayList<Member>
): RecyclerView.Adapter<ListDetailMemberAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallBack: OnItemClickCallBack

    fun setOnItemClickCallBack(onItemClickCallBack: OnItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack
    }

    interface OnItemClickCallBack {
        fun onItemClicked(data: Member)
    }


    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.iv_foto_column)
        val tvNamaPanggilan: TextView = itemView.findViewById(R.id.tv_nama_paggilan_column)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list_detail_member, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (photo, _, _, _, _, _, namaPanggilan) = listMember[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvNamaPanggilan.text = namaPanggilan

        holder.itemView.setOnClickListener {
            onItemClickCallBack.onItemClicked(listMember[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listMember.size
}