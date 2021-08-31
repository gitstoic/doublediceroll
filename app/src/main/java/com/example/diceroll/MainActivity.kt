package com.example.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.btn_roll)
        rollButton.setOnClickListener {
////            Toast.makeText(this, "Dice rolled", Toast.LENGTH_SHORT).show()
//            result.text = "5"
            rollDice()
        }
    }

    private fun rollDice() {
//        Create new dice object with 6 sides and roll it
        val dice = Dice (6)
        val diceRoll = dice.roll()
        val image1: ImageView = findViewById(R.id.diceImage1)
        val image2: ImageView = findViewById(R.id.diceImage2)

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        image1.setImageResource(drawableResource)

        val dice2 = Dice (6)
        val drawableResource2 = when (dice2.roll()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        image2.setImageResource(drawableResource2)



        }

    class Dice(private val sides: Int) {

        fun roll(): Int {
            return (1..sides).random()
        }
    }
}