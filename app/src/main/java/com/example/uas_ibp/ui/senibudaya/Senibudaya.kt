package com.example.uas_ibp.ui.senibudaya

//Nama        : Indi Bagus Prasetyo ;
//NIM         : 10121902 ;
//Kelas       : IF9K ;
//Mata Kuliah : Pemrograman Android ;
//Dosen       : Rizki Adam Kurniawan, M.Kom. ;
//Final       : Senin, 12 Agustus 2024 ;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uas_ibp.databinding.ActivitySenibudayaBinding

class Senibudaya : AppCompatActivity() {

    private lateinit var binding: ActivitySenibudayaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySenibudayaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = listOf(
            ItemData("images/wayang_golek.jpg", "Wayang Golek", "Wayang golek adalah seni pertunjukan wayang khas Sunda yang menggunakan boneka kayu sebagai mediumnya. Wayang golek menampilkan cerita-cerita pewayangan yang sarat dengan nilai-nilai luhur."),
            ItemData("images/jaipong.jpg", "Tari Jaipong", "Tari Jaipong adalah tarian tradisional Sunda yang dinamis dan enerjik. Tarian ini biasanya dibawakan oleh penari wanita dengan gerakan-gerakan yang lincah dan ekspresif."),
            ItemData("images/gamelan.jpg", "Gamelan", "Gamelan Sunda adalah seperangkat alat musik tradisional yang terbuat dari perunggu. Bunyi yang dihasilkan gamelan Sunda sangat khas dan sering digunakan untuk mengiringi berbagai jenis pertunjukan seni."),
            ItemData("images/kacapi.jpg", "Kacapi", "Kacapi adalah alat musik petik tradisional Sunda yang memiliki dua buah badan dan dimainkan dengan cara dipetik. Kacapi sering digunakan sebagai pengiring lagu Sunda."),
            ItemData("images/kuda_lumping.jpg", "Kuda Lumping", "Kuda lumping adalah seni pertunjukan tradisional yang menggambarkan gerakan kuda. Penari akan menari dengan gerakan-gerakan yang menyerupai kuda sambil diiringi musik tradisional."),
            ItemData("images/kuda_renggong.jpg", "Kuda Renggong", "Kuda renggong adalah tarian tradisional Sunda yang melibatkan penari dan kuda. Penari akan menari di atas punggung kuda yang berjalan mengikuti irama musik."),
            ItemData("images/sisingaan.jpg", "Sisingaan", "Sisingaan adalah seni pertunjukan tradisional yang menggunakan topeng singa. Penari akan mengenakan topeng singa dan menari mengikuti irama musik."),
            ItemData("images/suling_sunda.jpg", "Seruling Sunda", "Seruling Sunda adalah alat musik tiup tradisional yang terbuat dari bambu. Seruling Sunda memiliki suara yang merdu dan sering digunakan sebagai pengiring lagu Sunda."),
            ItemData("images/tari_merak.jpg", "Tari Merak", "Tari Merak adalah tarian tradisional Sunda yang terinspirasi dari gerakan burung merak. Tarian ini menampilkan keindahan dan keanggunan burung merak."),
            ItemData("images/tari_sintren.jpg", "Tari Sintren", "Tari Sintren adalah tarian tradisional Sunda yang memiliki unsur mistis. Tarian ini sering dilakukan pada acara-acara tertentu dan melibatkan seorang penari yang dirasuki oleh roh halus."),
            ItemData("images/tari_topeng.jpg", "Tari Topeng", "Tari Topeng adalah tarian tradisional Sunda yang menggunakan topeng. Tarian ini biasanya menceritakan kisah-kisah rakyat atau sejarah."),
            ItemData("images/degung.jpg", "Degung", "Degung adalah alat musik pukul tradisional Sunda yang terbuat dari bahan kayu. Degung menghasilkan suara yang lembut dan merdu, sering digunakan untuk mengiringi lagu-lagu Sunda.")
        )

        val adapter = ImageCardAdapterSenibudaya(items)
        binding.recyclerViewSenibudaya.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewSenibudaya.adapter = adapter
    }
}

data class ItemData(val imageUrl: String, val title: String, val description: String)
