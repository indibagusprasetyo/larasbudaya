package com.example.uas_ibp.ui.home

//Nama        : Indi Bagus Prasetyo ;
//NIM         : 10121902 ;
//Kelas       : IF9K ;
//Mata Kuliah : Pemrograman Android ;
//Dosen       : Rizki Adam Kurniawan, M.Kom. ;
//Final       : Senin, 12 Agustus 2024 ;

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.uas_ibp.databinding.FragmentHomeBinding
import com.example.uas_ibp.ui.aksara.Aksara
import com.example.uas_ibp.ui.sejarah.Sejarah
import com.example.uas_ibp.ui.senibudaya.Senibudaya

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.card1Button.setOnClickListener {
            val intent = Intent(activity, Senibudaya::class.java)
            startActivity(intent)
        }

        binding.card2Button.setOnClickListener {
            val intent = Intent(activity, Aksara::class.java)
            startActivity(intent)
        }

        binding.card3Button.setOnClickListener {
            val intent = Intent(activity, Sejarah::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
