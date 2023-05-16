package com.example.a6__hw_2.selected.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.a6__hw_2.databinding.ItemPhotoBinding
import com.example.a6__hw_2.model.Photo

class PhotoAdapter(
    private val list: ArrayList<Photo>,
    private val clickListener: (Photo) -> Unit,
    private val deleteItem: (Photo) -> Unit
) : Adapter<PhotoAdapter.PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            ItemPhotoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class PhotoViewHolder(private var binding: ItemPhotoBinding) : ViewHolder(binding.root) {
        fun bind(photo: Photo) {
            binding.vBlack.isVisible = photo.isSelected

            Glide.with(itemView.context).load(photo.photo).into(binding.ivPhoto)

            itemView.setOnClickListener {
                if (photo.isSelected) {
                    deleteItem(photo)
                    photo.isSelected = false
                    notifyItemChanged(adapterPosition)
                } else {
                    clickListener(photo)
                    photo.isSelected = true
                    notifyItemChanged(adapterPosition)
                }
            }
        }
    }
}