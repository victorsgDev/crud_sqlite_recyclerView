package com.example.hi_programacionmovil_victorsanchez

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper



class DataHelper(private val context: Context) : SQLiteOpenHelper(
    context, NOMBRE_DATABASE, null,
    VERSION_DATABASE
) {
    companion object {
        val NOMBRE_DATABASE = "tienda.db"
        val VERSION_DATABASE = 1
        val NOMBRE_TABLE = "productos"
        val CAMPO_CODIGO = "codigo"
        val CAMPO_NOMBRE = "nombre"
        val CAMPO_UNIDADES = "unidades"
    }

    override fun onCreate(db: SQLiteDatabase?) {

        var CREAR_TABLE =
            ("CREATE TABLE productos (codigo INTEGER PRIMARY KEY,nombre TEXT NOT NULL,unidades INTEGER)")
        if (db != null) {
            db.execSQL(CREAR_TABLE)
            println("base de datos creada")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun addProducto(producto: Producto) {
        var db = this.writableDatabase
        var values = ContentValues()
        values.put(CAMPO_CODIGO, producto.codigo)
        values.put(CAMPO_NOMBRE, producto.nombre)
        values.put(CAMPO_UNIDADES, producto.unidades)
        db.insert(NOMBRE_TABLE, null, values)
        println("producto añadido")

    }

    fun mostrarProductos(): ArrayList<Producto> {
        println("Listado de productos")
        var listaProductos = ArrayList<Producto>()
        var db = this.writableDatabase
        var resultado = db.rawQuery("select * from productos", null)
        if (resultado.moveToFirst()) {
            do {
                val producto = Producto(0, "", 0)
                producto.codigo = resultado.getInt(0)
                producto.nombre = resultado.getString(1)
                producto.unidades = resultado.getInt(2)
                listaProductos.add(producto)
            } while (resultado.moveToNext())
        }

        println(listaProductos)
        return listaProductos
    }
}
