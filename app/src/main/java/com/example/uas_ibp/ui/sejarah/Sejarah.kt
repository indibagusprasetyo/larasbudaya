package com.example.uas_ibp.ui.sejarah

//Nama        : Indi Bagus Prasetyo ;
//NIM         : 10121902 ;
//Kelas       : IF9K ;
//Mata Kuliah : Pemrograman Android ;
//Dosen       : Rizki Adam Kurniawan, M.Kom. ;
//Final       : Senin, 12 Agustus 2024 ;

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.uas_ibp.R
import com.google.android.material.card.MaterialCardView

class Sejarah : AppCompatActivity() {

    private lateinit var cardZamanPrasejarah: MaterialCardView
    private lateinit var contentZamanPrasejarah: LinearLayout
    private lateinit var cardKerajaanTarumanagara: MaterialCardView
    private lateinit var contentKerajaanTarumanagara: LinearLayout
    private lateinit var cardKerajaanGaluh: MaterialCardView
    private lateinit var contentKerajaanGaluh: LinearLayout
    private lateinit var cardKerajaanSunda: MaterialCardView
    private lateinit var contentKerajaanSunda: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sejarah)

        cardZamanPrasejarah = findViewById(R.id.card_zaman_prasejarah)
        contentZamanPrasejarah = findViewById(R.id.contentZamanPrasejarah)
        cardKerajaanTarumanagara = findViewById(R.id.card_kerajaan_tarumanagara)
        contentKerajaanTarumanagara = findViewById(R.id.contentKerajaanTarumanagara)
        cardKerajaanGaluh = findViewById(R.id.card_kerajaan_galuh)
        contentKerajaanGaluh = findViewById(R.id.contentKerajaanGaluh)
        cardKerajaanSunda = findViewById(R.id.card_kerajaan_sunda)
        contentKerajaanSunda = findViewById(R.id.contentKerajaanSunda)

        cardZamanPrasejarah.setOnClickListener {
            toggleContentVisibility(contentZamanPrasejarah)
        }

        cardKerajaanTarumanagara.setOnClickListener {
            toggleContentVisibility(contentKerajaanTarumanagara)
        }

        cardKerajaanGaluh.setOnClickListener {
            toggleContentVisibility(contentKerajaanGaluh)
        }

        cardKerajaanSunda.setOnClickListener {
            toggleContentVisibility(contentKerajaanSunda)
        }
    }

    private fun toggleContentVisibility(contentLayout: LinearLayout) {
        if (contentLayout.visibility == LinearLayout.VISIBLE) {
            contentLayout.visibility = LinearLayout.GONE
        } else {
            contentLayout.visibility = LinearLayout.VISIBLE
        }
    }
}
