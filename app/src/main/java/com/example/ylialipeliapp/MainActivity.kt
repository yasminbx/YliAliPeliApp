package com.example.ylialipeliapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var peli: YliAliPeli

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textInfo = findViewById<TextView>(R.id.textInfo)
        val inputArvaus = findViewById<EditText>(R.id.inputArvaus)
        val buttonArvaa = findViewById<Button>(R.id.buttonArvaa)
        val textTulos = findViewById<TextView>(R.id.textTulos)

        peli = YliAliPeli(1, 100)

        buttonArvaa.setOnClickListener {
            val arvausStr = inputArvaus.text.toString()

            if (arvausStr.isEmpty()) {
                Toast.makeText(this, "Syötä numero!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val arvaus = arvausStr.toInt()
            val tulos = peli.arvaa(arvaus)

            when (tulos) {
                YliAliPeli.Arvaustulos.Low -> textTulos.text = "Liian pieni!"
                YliAliPeli.Arvaustulos.High -> textTulos.text = "Liian suuri!"
                YliAliPeli.Arvaustulos.Hit -> {
                    textTulos.text = "Oikein! Arvauksia yhteensä: ${peli.guesses}"
                    buttonArvaa.isEnabled = false
                }
            }

            inputArvaus.text.clear()
        }
    }
}