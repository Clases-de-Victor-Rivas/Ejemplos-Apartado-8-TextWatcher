package es.vrivas.ejemplosapartado8textwatcher

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import es.vrivas.ejemplosapartado8textwatcher.R.id.et_palabra
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.min

class MainActivity : AppCompatActivity() {
    var lista = listOf<String>("ahorro", "barco", "barquito", "boquerón", "fichero", "ficticio", "tender", "tendencia", "tomar")

    // 3ª Versión de la captura de eventos: una clase adicional maneja los eventos.
    // Al declarar la clase como inner podemos acceder a todos los métodos de la clase contenedora
    inner class ManejadorEventos: TextWatcher {
        // Imprescindible ponerlo, porque TextWatcher es abstracto
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        // Imprescindible ponerlo, porque TextWatcher es abstracto
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        // Actualiza la lista de palabras
        override fun afterTextChanged(s: Editable?) {
            val coinciden = seleccionar_palabras(et_palabra.text.toString())
            tv_lista_palabras.text=coinciden.toString()
        }
    }

    // Este método filtra las palabras que empiezan por las letras introducidas por el usuario
    private fun seleccionar_palabras(raiz: String): MutableList<String> {
        return lista.filter{ it.substring(0, min(raiz.length,it.length))==raiz} as MutableList<String>
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        // 1ª Versión de la captura de eventos: la actividad captura el evento
        // Indico al EditText et_palabra que su manejador de eventos es la propia actividad
        //et_palabra.addTextChangedListener(this)
        */

        /*
        // 2ª Versión de la captura de eventos: el propio widget captura el evento
        // Al mismo tiempo que le añado el listener, declaro el objeto que manejará los eventos
        et_palabra.addTextChangedListener( object: TextWatcher {

            // Imprescindible ponerlo, porque TextWatcher es abstracto
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            // Imprescindible ponerlo, porque TextWatcher es abstracto
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            // Actualiza la lista de palabras
            override fun afterTextChanged(s: Editable?) {
                val coinciden = seleccionar_palabras(et_palabra.text.toString())
                tv_lista_palabras.text=coinciden.toString()
            }
        })
        */

        // 3ª Versión de la captura de eventos: una clase adicional maneja los eventos.
        // Indicamos qué clase es la que manejará los eventos.
        et_palabra.addTextChangedListener(ManejadorEventos())

    }

     /*
    // 1ª Versión de la captura de eventos: la actividad captura el evento
    // Tengo que implementar TODOS los métodos abstractos, aunque no se usen

    // Imprescindible ponerlo, porque TextWatcher es abstracto
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    // Imprescindible ponerlo, porque TextWatcher es abstracto
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    // Actualiza la lista de palabras
    override fun afterTextChanged(s: Editable?) {
        val coinciden = seleccionar_palabras(et_palabra.text.toString())
        tv_lista_palabras.text=coinciden.toString()
    }
    */
}