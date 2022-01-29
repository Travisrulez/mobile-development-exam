package com.example.exam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.databinding.ItemUsersBinding

class UsersAdapter(private val list: List<Data>, val itemClick: (Data) -> Unit) :
    RecyclerView.Adapter<UsersAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val picture = list[position]
        holder.bind(picture)
    }

    override fun getItemCount(): Int = list.size

    inner class Holder internal constructor(
        private val binding: ItemUsersBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Data) = binding.run {
            userName.text = data.name
            userSurname.text = data.surname
            userPicture.setImageResource(data.pictureRes)
            userBio.text = data.minimalInfo

            itemView.setOnClickListener { itemClick(data) }
        }

    }
}