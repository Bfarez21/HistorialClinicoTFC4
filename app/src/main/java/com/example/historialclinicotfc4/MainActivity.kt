package com.example.historialclinicotfc4

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.content.Context
import com.google.android.material.button.MaterialButton


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var pacienteAdapter: PacienteAdapter
    private lateinit var pacientes: List<Paciente>
    private lateinit var hombreButton: MaterialButton
    private lateinit var mujerButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        hombreButton = findViewById(R.id.hombreButton)
        mujerButton = findViewById(R.id.mujerButton)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val apiService = RetrofitClient.retrofit.create(ApiService::class.java)
        val call = apiService.getPacientes()

        call.enqueue(object : Callback<List<Paciente>> {
            override fun onResponse(call: Call<List<Paciente>>, response: Response<List<Paciente>>) {
                if (response.isSuccessful) {
                    pacientes = response.body() ?: emptyList()
                    updateRecyclerView(pacientes)
                } else {
                    Log.e("MainActivity", "Error en la respuesta: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<List<Paciente>>, t: Throwable) {
                Log.e("MainActivity", "Error en la llamada a la API", t)
            }
        })

        hombreButton.setOnClickListener {
            val filteredList = pacientes.filter { it.generoPac.equals("masculino", ignoreCase = true) }
            updateRecyclerView(filteredList)
        }

        mujerButton.setOnClickListener {
            val filteredList = pacientes.filter { it.generoPac.equals("femenino", ignoreCase = true) }
            updateRecyclerView(filteredList)

        }
    }

    private fun updateRecyclerView(pacientes: List<Paciente>) {
        runOnUiThread {
            pacienteAdapter = PacienteAdapter(pacientes, this)
            recyclerView.adapter = pacienteAdapter
        }
    }
}
