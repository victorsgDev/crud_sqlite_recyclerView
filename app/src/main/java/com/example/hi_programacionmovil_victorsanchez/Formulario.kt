package com.example.hi_programacionmovil_victorsanchez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hi_programacionmovil_victorsanchez.databinding.ActivityFormularioBinding
import com.example.hi_programacionmovil_victorsanchez.databinding.ActivityMainBinding

class Formulario : AppCompatActivity() {
    private lateinit var binding: ActivityFormularioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var codigo:EditText=binding.etCodigo
        var nombre:EditText=binding.etNombre
        var unidades:EditText=binding.etUnidades

        val boton_add: Button =binding.btnAdd
        val boton_select: Button =binding.btnSelect
        val recycler: RecyclerView =binding.rvProductos

        val dh=DataHelper(this)

        boton_add.setOnClickListener(){
            var c=Integer.parseInt(codigo.text.toString())
            var n=nombre.text.toString()
            var u=Integer.parseInt(unidades.text.toString())

            dh.addProducto(Producto(c,n,u))
        }
        boton_select.setOnClickListener(){
            var listado=dh.mostrarProductos()

            var adaptador = ProductoAdapter(this@Formulario,listado)
            recycler.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@Formulario)
                adapter = adaptador
            }

        }
    }
}