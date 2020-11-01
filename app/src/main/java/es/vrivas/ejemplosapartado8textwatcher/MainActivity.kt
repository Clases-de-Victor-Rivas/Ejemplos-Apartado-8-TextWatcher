package es.vrivas.ejemplosapartado8textwatcher

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var lista = listOf<String>("ahorro", "barco", "barquito", "boquerón", "fichero", "ficticio", "tender", "tendencia", "tomar")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buscar_palabras(raiz: String): MutableList<String> {
        var toRet = lista.filter{ it.substring(0,raiz.length)==raiz} as MutableList<String>
        return toRet
    }

    fun buscar(view: View){
        var a=buscar_palabras(et_palabra.text.toString())
    }
}