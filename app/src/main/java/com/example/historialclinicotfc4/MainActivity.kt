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


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var pacienteAdapter: PacienteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val apiService = RetrofitClient.retrofit.create(ApiService::class.java)
        val call = apiService.getPacientes()

        call.enqueue(object : Callback<List<Paciente>> {
            override fun onResponse(call: Call<List<Paciente>>, response: Response<List<Paciente>>) {
                if (response.isSuccessful) {
                    val pacientes = response.body() ?: emptyList()
                    Log.d("MainActivity", "Datos de Pacientes: $pacientes")
                    runOnUiThread {
                        pacienteAdapter = PacienteAdapter(pacientes,this@MainActivity)
                        recyclerView.adapter = pacienteAdapter
                    }
                } else {
                    Log.e("MainActivity", "Error en la respuesta: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<List<Paciente>>, t: Throwable) {
                Log.e("MainActivity", "Error en la llamada a la API", t)
            }
        })
    }
}
