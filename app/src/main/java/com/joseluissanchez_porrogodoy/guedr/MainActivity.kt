package com.joseluissanchez_porrogodoy.guedr

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{



    val TAG = MainActivity::class.java.canonicalName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.stone_button).setOnClickListener(this)
        findViewById<Button>(R.id.donkey_button).setOnClickListener(this)

        Log.v(TAG,"He pasado por onCreate")

        if(savedInstanceState != null){
            Log.v(TAG," savedInstanceState no es null y la clave vale: ${savedInstanceState.getString("clave")}")

        }else{
            Log.v(TAG," savedInstanceState es null")
        }
    }
    // TODO: Esto pendiente
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.v(TAG,"He pasado por onSaveInstanceState")

        if(outState != null){
            // Aquí estamos seguros de que podemos llamar a métodos de outState sin NPE
            outState.putString("clave","valor")
        }
    }
    override fun onClick(v: View?) {
/*
        if (v == stoneButton){
            Log.v(TAG,"han Pasado por el boton piedra")
        }else{
            Log.v(TAG,"han pasado por el boton burro")
        }*/
        // KOTLIN se da cuenta de de que v no es null y te permite escribirlo sin el ? de nullable
/*        if(v != null){
            if(v.getId() == R.id.stone_button){
                Log.v(TAG,"han Pasado por el boton piedra")
            }else{
                Log.v(TAG,"han pasado por el boton burro")
            }
        }*/
/*
        when (v?.id){
            R.id.stone_button -> {
                val a = 0
                Log.v(TAG,"Ha pasado por el boton piedra")}
            R.id.donkey_button-> Log.v(TAG,"Ha pasado por el boton burro")
        }*/
        Log.v(TAG, when(v?.id){
            R.id.stone_button -> "Ha pasado por el boton piedra"
            R.id.donkey_button -> "Ha pasado por el boton burro"
            else -> "No sé cual ha pulsado"
        })

    }
}
