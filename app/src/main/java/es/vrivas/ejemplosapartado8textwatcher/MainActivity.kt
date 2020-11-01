package es.vrivas.ejemplosapartado8textwatcher

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TextWatcher {
    var lista = listOf<String>("ahorro", "barco", "barquito", "boquerón", "fichero", "ficticio", "tender", "tendencia", "tomar")

    // Este método filtra las palabras que empiezan por las letras introducidas por el usuario
    private fun seleccionar_palabras(raiz: String): MutableList<String> {
        return lista.filter{ it.substring(0,raiz.length)==raiz} as MutableList<String>
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1ª Versión de la captura de eventos
        // Indico al EditText et_palabra que su manejador de eventos es la propia actividad
        et_palabra.addTextChangedListener(this)
    }

    // 1ª Versión de la captura de eventos.
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
}