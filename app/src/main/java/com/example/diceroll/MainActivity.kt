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
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val image: ImageView = findViewById(R.id.diceImage)

//        when(diceRoll) {
//            1 -> image.setImageResource(R.drawable.dice_1)
//            2 -> image.setImageResource(R.drawable.dice_2)
//            3 -> image.setImageResource(R.drawable.dice_3)
//            4 -> image.setImageResource(R.drawable.dice_4)
//            5 -> image.setImageResource(R.drawable.dice_5)
//            6 -> image.setImageResource(R.drawable.dice_6)
//        }
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        image.setImageResource(drawableResource)
        image.contentDescription = diceRoll.toString()
    }

    class Dice(private val sides: Int) {

        fun roll(): Int {
            return (1..sides).random()
        }
    }
}