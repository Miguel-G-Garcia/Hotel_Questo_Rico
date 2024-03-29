package com.miguel.proyecto_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miguel.proyecto_android.databinding.ViewReservaBinding

class ReservaAdapter (
    val context: ReservaListFragment,
    val listener: (Reserva) -> Unit)
    : RecyclerView.Adapter<ReservaAdapter.ViewHolder>() {

    var reservas = emptyList<Reserva>()

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
            val binding = ViewReservaBinding.bind(view)
            fun bind(reserva: Reserva){
                with(binding) {
                    fecha.text = reserva.fecha
                    Glide.with(imageView)
                        .load(reserva.foto)
                        .into(imageView)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_reserva, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = reservas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(reservas[position])
        holder.itemView.setOnClickListener { listener(reservas[position]) }
        holder.binding.btnBorrar.setOnClickListener { context.onBorrar(position)}
        holder.binding.btnModificar.setOnClickListener { context.onModificar(position) }
    }

}