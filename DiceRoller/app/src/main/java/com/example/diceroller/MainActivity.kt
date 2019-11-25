package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

//        val countUpButton: Button = findViewById(R.id.count_up_button)
//        countUpButton.setOnClickListener { countUp() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset() }
    }

    private fun rollDice() {
        val randomInt = Random.nextInt(6) + 1

        val diceImage: ImageView = findViewById(R.id.dice_image)
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
    }

//    private fun countUp() {
//        val resultText: TextView = findViewById(R.id.result_text)
//        var countedUp = 1
//        if (resultText.text != "Hello World!") {
//            if (resultText.text.toString().toInt() != 6) {
//                 countedUp = resultText.text.toString().toInt() + 1
//            }
//            else {
//                 countedUp = resultText.text.toString().toInt()
//             }
//        }
//
//        resultText.text = countedUp.toString()
//    }

    private fun reset() {
        val diceImage: ImageView = findViewById(R.id.dice_image)
        diceImage.setImageResource(R.drawable.empty_dice)
    }
}
