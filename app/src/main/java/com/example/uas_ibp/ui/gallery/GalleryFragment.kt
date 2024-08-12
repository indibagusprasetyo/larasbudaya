package com.example.uas_ibp.ui.gallery

//Nama        : Indi Bagus Prasetyo ;
//NIM         : 10121902 ;
//Kelas       : IF9K ;
//Mata Kuliah : Pemrograman Android ;
//Dosen       : Rizki Adam Kurniawan, M.Kom. ;
//Final       : Senin, 12 Agustus 2024 ;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uas_ibp.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val imagePaths = listOf(
            "images/wayang_golek.jpg" to "Wayang Golek",
            "images/jaipong.jpg" to " Tari Jaipong",
            "images/gamelan.jpg" to "Gamelan",
            "images/kacapi.jpg" to "Kacapi",
            "images/kuda_lumping.jpg" to "Kuda Lumping",
            "images/kuda_renggong.jpg" to "Kuda Renggong",
            "images/sisingaan.jpg" to "Sisingaan",
            "images/suling_sunda.jpg" to "Seruling Sunda",
            "images/tari_merak.jpg" to "Tari Merak",
            "images/tari_sintren.jpg" to "Tari Sintren",
            "images/tari_topeng.jpg" to "Tari Topeng",
            "images/degung.jpg" to "Degung"
        )

        val adapter = ImageAdapter(imagePaths)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
