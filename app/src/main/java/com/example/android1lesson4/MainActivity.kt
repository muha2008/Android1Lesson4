package com.example.android1lesson4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            ivWhatsapp.setImageURI(uri)
        }

    private lateinit var ivWhatsapp: ImageView
    private lateinit var etNumber: EditText
    private lateinit var btnWhatsapp: Button
    private lateinit var btnGoogle: Button
    private lateinit var btnYouTube: Button
    private lateinit var btnGoTo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnGoTo = this.findViewById(R.id.btn_goto)
        ivWhatsapp = this.findViewById(R.id.iv_what)
        etNumber = this.findViewById(R.id.ed_number)
        btnWhatsapp = this.findViewById(R.id.btn_what)
        btnGoogle = this.findViewById(R.id.btn_Google)
        btnYouTube = this.findViewById(R.id.btn_youtube)
        btnGoTo = this.findViewById(R.id.btn_goto)

        goToWhatsapp()
        goTOGoogle()
        goToYouTube()
        goToActivity()
    }

    private fun goToActivity() {
        btnGoTo.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    private fun goToWhatsapp() {
        btnWhatsapp.setOnClickListener {
            val phoneNumber = etNumber.text.toString().trim()
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber")
            startActivity(intent)
        }
        ivWhatsapp.setOnClickListener {
            openGallery()
        }
    }

    private fun openGallery() {
        getContent.launch("image/*")
    }

    private fun goTOGoogle() {
        btnGoogle.setOnClickListener {
            val google = btnGoogle.text.toString().trim()
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data =
                Uri.parse("https://www.google.ru/?hl=ru=$google")
            startActivity(intent)
        }
    }

    private fun goToYouTube() {
        btnYouTube.setOnClickListener {
            val youtube = btnYouTube.text.toString().trim()
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.youtube.com/watch?v=2BsCdevQ8kE&list=RDMM2BsCdevQ8kE&start_radio=1=${youtube}")
            startActivity(intent)
        }
    }
}