package com.example.historialclinicotfc4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.content.Context
import androidx.core.content.ContextCompat.startActivity

        //Context sirve para iniciar nuevas actividades
class PacienteAdapter(private val pacientes: List<Paciente>,private val context: Context) : RecyclerView.Adapter<PacienteAdapter.PacienteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PacienteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_paciente, parent, false)
        return PacienteViewHolder(view)
    }

    override fun onBindViewHolder(holder: PacienteViewHolder, position: Int) {
        val paciente = pacientes[position]
        holder.cedulaPac.text = paciente.cedulaPac
        holder.nombrePac.text = paciente.nombrePac
        holder.apellidoPac.text = paciente.apellidoPac
        holder.profesionPac.text = paciente.profesionPac

        // putextars para pasar los datos a vista detalle
        //context es la clase paciuenteAdapter
        holder.itemView.setOnClickListener {
            val intent = Intent(context,PacienteDetalle::class.java).apply {
                putExtra("Rol",paciente.profesionPac)
                putExtra("cedula", paciente.cedulaPac)
                putExtra("nombre", paciente.nombrePac)
                putExtra("apellido", paciente.apellidoPac)
                putExtra("Fecha Nacimiento", paciente.fechaNacimientoPac)
                putExtra("Lugar",paciente.lugarPac)
                putExtra("Pais", paciente.paisPac)
                putExtra("Dirección",paciente.direccionPac)
                putExtra("Barrio", paciente.barrioPac)
                putExtra("Parroquia",paciente.parroquiaPac)
                putExtra("Cantón",paciente.cantonPac)
                putExtra("Provincia",paciente.provinciaPac)
                putExtra("Teléfono",paciente.telefonoPac)
                putExtra("Género", paciente.generoPac)
                putExtra("Estado Civil",paciente.estadoCivilPac)
                putExtra("Tipo Sangre",paciente.tipoSangrePac)
                putExtra("Carrera",paciente.carreraPac)
                putExtra("Ciclo",paciente.cicloPac)
            }
            // Inicia detalle
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return pacientes.size
    }

    class PacienteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cedulaPac: TextView = itemView.findViewById(R.id.cedulaPac)
        val nombrePac: TextView = itemView.findViewById(R.id.nombrePac)
        val apellidoPac: TextView = itemView.findViewById(R.id.apellidoPac)
        val profesionPac: TextView = itemView.findViewById(R.id.profesionPac)

    }
}
