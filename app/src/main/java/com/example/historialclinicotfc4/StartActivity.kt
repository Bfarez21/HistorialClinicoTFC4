package com.example.historialclinicotfc4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
class StartActivity:AppCompatActivity() {
    private lateinit var resultBT: Button
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity)
        // relacion con el boton
        resultBT = findViewById(R.id.result)

        resultBT.setOnClickListener{
            // Crea un intent para iniciar MainActivity y pasa los datos
            val intent = Intent(this@StartActivity, MenuActivity::class.java).apply {
                // putExtra parea pasar datos de ser necesario
            }
            // Inicia MainActivity
            startActivity(intent)
        }
    }
}