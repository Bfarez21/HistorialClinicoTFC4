package com.example.historialclinicotfc4
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("pacientes")
    fun getPacientes(): Call<List<Paciente>>
}