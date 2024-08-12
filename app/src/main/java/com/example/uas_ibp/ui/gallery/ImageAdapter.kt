package com.example.uas_ibp.ui.gallery

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
import com.example.uas_ibp.databinding.ItemCardBinding
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class ImageAdapter(private val items: List<Pair<String, String>>) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    private val storageRef: StorageReference = FirebaseStorage.getInstance().reference

    inner class ImageViewHolder(val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val (imagePath, title) = items[position]
        val imageRef: StorageReference = storageRef.child(imagePath)

        imageRef.downloadUrl.addOnSuccessListener { uri ->
            Glide.with(holder.itemView.context)
                .load(uri)
                .override(800, 600)
                .centerCrop()
                .into(holder.binding.imageView)
        }.addOnFailureListener {
            // Handle errors
        }

        holder.binding.titleTextView.text = title
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
