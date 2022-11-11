package com.example.hi_programacionmovil_victorsanchez

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hi_programacionmovil_victorsanchez.databinding.ActivityFormularioBinding

class ProductoAdapter(private val context: Context, private var listado:ArrayList<Producto>):
    RecyclerView.Adapter<ProductoAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_producto,parent,false))
    }

    override fun onBindViewHolder(holder: ProductoAdapter.ViewHolder, position: Int) {
        holder.onBind(listado[position])
    }

    override fun getItemCount(): Int {
        return listado.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun onBind(producto: Producto){
            itemView.findViewById<TextView>(R.id.tv_codigo).text=producto.codigo.toString()
            itemView.findViewById<TextView>(R.id.tv_nombre).text=producto.nombre
            itemView.findViewById<TextView>(R.id.tv_unidades).text=producto.unidades.toString()
        }

    }

}