package com.example.blackjack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var winner: TextView
    private lateinit var pointPlayer1: TextView
    private lateinit var pointPlayer2: TextView
    private lateinit var buttonPlayer1: Button
    private lateinit var buttonPlayer2: Button
    private lateinit var reset: Button
    private lateinit var fin1: Button
    private lateinit var fin2: Button
    private lateinit var imagen1: ImageView
    private lateinit var imagen2: ImageView
    var number1 = 0
    var number2 = 0
    var plato1: Boolean = false
    var plato2: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        winner = findViewById(R.id.winner)
        pointPlayer1 = findViewById(R.id.pointplayer1)
        pointPlayer2 = findViewById(R.id.pointplayer2)
        buttonPlayer1 = findViewById(R.id.button_player1)
        buttonPlayer2 = findViewById(R.id.button_player2)
        buttonPlayer2.isEnabled = false
        fin1 = findViewById(R.id.fin1)
        fin2 = findViewById(R.id.fin2)
        fin2.isEnabled = false

        reset = findViewById(R.id.button_reset)
        imagen1 = findViewById(R.id.image_player1)
        imagen2 = findViewById(R.id.image_player2)
        imagen1.setImageResource(R.drawable.dado0)
        imagen2.setImageResource(R.drawable.dado0)
        fin1.setOnClickListener {
            buttonPlayer1.isEnabled = false
            fin1.isEnabled = false
            if (plato2) {
                if (number1 >= number2) {
                    if(number1>number2) {
                        winner.text = "El jugador 2 ha ganado"
                    }
                    else{
                        winner.text = "Empate"
                    }
                } else {
                    winner.text = "El jugador 1 ha ganado"
                }
            }


            if (!plato2) {
                buttonPlayer2.isEnabled = true
                fin2.isEnabled = true
                plato1 = true
            }


        }
        fin2.setOnClickListener {
            buttonPlayer2.isEnabled = false
            fin2.isEnabled = false
            if (plato1) {
                if (number1 >= number2) {
                    if(number1>number2){
                        winner.text = "El jugador 2 ha ganado"
                    }
                    else{
                        winner.text = "Empate!"
                    }

                } else {
                    winner.text = "El jugador 1 ha ganado"
                }
            }
            if (!plato1) {
                buttonPlayer1.isEnabled = true
                fin1.isEnabled = true
                plato2 = true
            }
        }

        buttonPlayer1.setOnClickListener {
            var numeroAleatorio = (1..6).shuffled().first()
            when (numeroAleatorio) {
                1 -> imagen1.setImageResource(R.drawable.dado1)
                2 -> imagen1.setImageResource(R.drawable.dado2)
                3 -> imagen1.setImageResource(R.drawable.dado3)
                4 -> imagen1.setImageResource(R.drawable.dado4)
                5 -> imagen1.setImageResource(R.drawable.dado5)
                6 -> imagen1.setImageResource(R.drawable.dado6)
            }
            number1 = number1 + numeroAleatorio
            if (number1 >= 21) {
                if (number1 == 21) {
                    winner.text = "El jugador 2 ha ganado"

                } else {
                    winner.text = "El jugador 1 ha ganado"

                }

            }
            pointPlayer1.text = number1.toString()
            if (!plato2) {
                buttonPlayer2.isEnabled = true
                fin1.isEnabled = false
                fin2.isEnabled = true
                buttonPlayer1.isEnabled = false
            }


        }
        buttonPlayer2.setOnClickListener {
            var numeroAleatorio = (1..6).shuffled().first()
            when (numeroAleatorio) {
                1 -> imagen2.setImageResource(R.drawable.dado1)
                2 -> imagen2.setImageResource(R.drawable.dado2)
                3 -> imagen2.setImageResource(R.drawable.dado3)
                4 -> imagen2.setImageResource(R.drawable.dado4)
                5 -> imagen2.setImageResource(R.drawable.dado5)
                6 -> imagen2.setImageResource(R.drawable.dado6)
            }
            number2 = number2 + numeroAleatorio
            if (number2 >= 21) {
                if (number2 == 21) {

                    winner.text = "El jugador 1 ha ganado con"

                } else {

                    winner.text = "El jugador 2 ha ganado"

                }

            }
            pointPlayer2.text = number2.toString()
            if (!plato1) {
                buttonPlayer1.isEnabled = true
                fin2.isEnabled = false
                fin1.isEnabled = true
                buttonPlayer2.isEnabled = false
            }


        }
        reset.setOnClickListener {
            resetFunc()
        }


    }

    fun resetFunc() {
        pointPlayer1.text = "0"
        pointPlayer2.text = "0"
        number1 = 0
        number2 = 0
        buttonPlayer1.isEnabled = true
        buttonPlayer2.isEnabled = false
        fin1.isEnabled = true
        fin2.isEnabled = false
        plato1 = false
        plato2 = false
        winner.text = ""
        imagen1.setImageResource(R.drawable.dado0)
        imagen2.setImageResource(R.drawable.dado0)
    }


}
