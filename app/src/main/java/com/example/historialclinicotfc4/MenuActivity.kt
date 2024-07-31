package com.example.historialclinicotfc4

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MenuActivity : AppCompatActivity() {
    private lateinit var cardClickPaci:CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        // Relacionar con el componente del XML
        cardClickPaci = findViewById(R.id.cardPaciente)

        // a donde quiero ir, primero paso el context=>vista actual
        cardClickPaci.setOnClickListener {
            val intent = Intent(this@MenuActivity,MainActivity::class.java).apply {

            }
            // Inicia detalle
             startActivity(intent)
        }
    }
}