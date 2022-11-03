package com.example.diceapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

// ger användare möjligheten att rulla tärningen och
// sen den på skärmen
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Kopplar knappen i xml till koden så den fungerar
        val rollButton: Button = (findViewById(R.id.button))

        // Ger knappen tryck funktionen
        rollButton.setOnClickListener {
            rollDice()

        }
    }
    // ger en klass för tärningen och sidor.
    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()

        }

    }
    // rullar tärningen och ger dig en siffra
    private fun rollDice() {
        //Ny tärning med sex sidor och den kastas igen
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // resultatet av det nya kastet ovan uppdateras här
        val diceImage: ImageView = findViewById(R.id.imageView)

        // nummren på tärningen kopplas till rätt bild
        val drawableResource = when (diceRoll){

            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // uppdaterar med denna rätta bilden .
        diceImage.setImageResource(drawableResource)

        diceImage.contentDescription = diceRoll.toString()

    }


}


