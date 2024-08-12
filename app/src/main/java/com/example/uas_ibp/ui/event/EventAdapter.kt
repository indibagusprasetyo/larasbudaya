package com.example.uas_ibp.ui.event

//Nama        : Indi Bagus Prasetyo ;
//NIM         : 10121902 ;
//Kelas       : IF9K ;
//Mata Kuliah : Pemrograman Android ;
//Dosen       : Rizki Adam Kurniawan, M.Kom. ;
//Final       : Senin, 12 Agustus 2024 ;

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uas_ibp.R
import com.example.uas_ibp.databinding.ItemEventBinding
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class EventAdapter : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    private val events = mutableListOf<Event>()
    private val storageRef: StorageReference = FirebaseStorage.getInstance().reference

    inner class EventViewHolder(val binding: ItemEventBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding = ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events[position]
        holder.binding.titleTextView.text = event.title
        holder.binding.descriptionTextView.text = event.description

        val imageRef: StorageReference = storageRef.child(event.imagePath)
        imageRef.downloadUrl.addOnSuccessListener { uri ->
            Log.d("EventAdapter", "Image URI: $uri")
            Glide.with(holder.itemView.context)
                .load(uri)
                .placeholder(R.drawable.placeholder_image)
                .error(R.drawable.placeholder_image)
                .centerCrop()
                .into(holder.binding.imageView)
        }.addOnFailureListener { exception ->
            Log.e("EventAdapter", "Error loading image", exception)
        }
    }

    override fun getItemCount(): Int = events.size

    fun submitList(newEvents: List<Event>) {
        events.clear()
        events.addAll(newEvents)
        notifyDataSetChanged()
    }
}
