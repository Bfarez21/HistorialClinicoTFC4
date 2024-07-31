package com.example.historialclinicotfc4

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class PacienteDetalle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_paciente_detalle)

        // obtener los datos desde el intent
        val profesion=intent.getStringExtra("Rol")
        val cedula=intent.getStringExtra("cedula")
        val nombre=intent.getStringExtra("nombre")
        val apellido=intent.getStringExtra("apellido")
        val genero=intent.getStringExtra("genero")
        val fechaNacimiento=intent.getStringExtra("Fecha Nacimiento")
        val lugar=intent.getStringExtra("Lugar")
        val pais=intent.getStringExtra("Pais")
        val direccion=intent.getStringExtra("Dirección")
        val barrio=intent.getStringExtra("Barrio")

        // Asignar los datos a las vistas correspondientes por id
        val profesionTextView: TextView = findViewById(R.id.profesionTextView)
        val cedulaTextView: TextView = findViewById(R.id.cedulaTextView)
        val nombreTextView: TextView = findViewById(R.id.nombreTextView)
        val apellidoTextView:TextView = findViewById(R.id.apellidoTextView)
        val generoTextView:TextView = findViewById(R.id.generoTextView)
        val fechaNaciTextView:TextView= findViewById(R.id.fechaNaciTextView)
        val lugarTextView:TextView=findViewById(R.id.lugarTextView)
        val paisTextView:TextView=findViewById(R.id.paisTextView)
        val direccionTextView:TextView=findViewById(R.id.direccionTextView)
        val barrioTextView:TextView=findViewById(R.id.barrioTextView)

        // Asignar los datos a las vistas correspondientes
        cedulaTextView.text = cedula
        nombreTextView.text = nombre
        apellidoTextView.text=apellido
        generoTextView.text=genero
        profesionTextView.text=profesion
        fechaNaciTextView.text=fechaNacimiento
        lugarTextView.text=lugar
        paisTextView.text=pais
        direccionTextView.text=direccion
        barrioTextView.text=barrio
    }
}