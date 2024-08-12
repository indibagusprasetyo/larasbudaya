package com.example.uas_ibp.ui.event

//Nama        : Indi Bagus Prasetyo ;
//NIM         : 10121902 ;
//Kelas       : IF9K ;
//Mata Kuliah : Pemrograman Android ;
//Dosen       : Rizki Adam Kurniawan, M.Kom. ;
//Final       : Senin, 12 Agustus 2024 ;

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uas_ibp.databinding.FragmentEventBinding
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class EventFragment : Fragment() {

    private var _binding: FragmentEventBinding? = null
    private val binding get() = _binding!!

    private lateinit var eventViewModel: EventViewModel
    private lateinit var eventAdapter: EventAdapter
    private val storageRef: StorageReference = FirebaseStorage.getInstance().reference

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        eventViewModel = ViewModelProvider(this).get(EventViewModel::class.java)

        _binding = FragmentEventBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val buttonSelectDate: Button = binding.buttonSelectDate
        val textSelectedDate: TextView = binding.textSelectedDate
        val textNoEvents: TextView = binding.textNoEvents
        val recyclerViewEvents: androidx.recyclerview.widget.RecyclerView = binding.recyclerViewEvents

        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

        buttonSelectDate.setOnClickListener {
            DatePickerDialog(requireContext(), { _, year, month, dayOfMonth ->
                calendar.set(year, month, dayOfMonth)
                val selectedDate = dateFormat.format(calendar.time)
                textSelectedDate.text = "Tanggal yang dipilih: $selectedDate"

                val events = getEventsForDate(selectedDate)
                if (events.isEmpty()) {
                    textNoEvents.visibility = View.VISIBLE
                    recyclerViewEvents.visibility = View.GONE
                } else {
                    textNoEvents.visibility = View.GONE
                    recyclerViewEvents.visibility = View.VISIBLE
                    eventAdapter.submitList(events)
                }
            },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        eventAdapter = EventAdapter()
        recyclerViewEvents.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewEvents.adapter = eventAdapter

        return root
    }

    private fun getEventsForDate(date: String): List<Event> {
        val eventMap = mapOf(
            "14/08/2024" to listOf(
                Event(
                    "Festival Seni Sunda di Bandung",
                    "Festival seni yang menampilkan berbagai kesenian Sunda.",
                    "images/gedungsatai.png"
                )
            ),
            "17/08/2024" to listOf(
                Event(
                    "Pameran Wayang Golek di Jakarta",
                    "Pameran yang menampilkan berbagai jenis wayang golek.",
                    "images/wayang.jpg"
                )
            ),
            "18/08/2024" to listOf(
                Event(
                    "Seminar Budaya Sunda di Universitas Padjadjaran",
                    "Seminar tentang pelestarian budaya Sunda.",
                    "images/unpadfest.jpg"
                )
            ),
            "25/08/2024" to listOf(
                Event(
                    "Workshop Tarian Jaipong di Gedung Kesenian",
                    "Workshop tentang teknik tari Jaipong.",
                    "images/jaipong.jpg"
                )
            )
        )
        return eventMap[date] ?: emptyList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
