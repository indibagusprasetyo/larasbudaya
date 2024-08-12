package com.example.uas_ibp.ui.senibudaya

//Nama        : Indi Bagus Prasetyo ;
//NIM         : 10121902 ;
//Kelas       : IF9K ;
//Mata Kuliah : Pemrograman Android ;
//Dosen       : Rizki Adam Kurniawan, M.Kom. ;
//Final       : Senin, 12 Agustus 2024 ;

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uas_ibp.databinding.ItemCardSenibudayaBinding
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class ImageCardAdapterSenibudaya(private val items: List<ItemData>) :
    RecyclerView.Adapter<ImageCardAdapterSenibudaya.ImageViewHolder>() {

    private val storageRef: StorageReference = FirebaseStorage.getInstance().reference

    inner class ImageViewHolder(val binding: ItemCardSenibudayaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemCardSenibudayaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item = items[position]
        val imageRef: StorageReference = storageRef.child(item.imageUrl)

        imageRef.downloadUrl.addOnSuccessListener { uri ->
            Glide.with(holder.itemView.context)
                .load(uri)
                .override(800, 600)
                .into(holder.binding.imageViewSenibudaya)
        }.addOnFailureListener {
        }

        holder.binding.titleTextViewSenibudaya.text = item.title
        holder.binding.descriptionTextViewSenibudaya.text = item.description
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
