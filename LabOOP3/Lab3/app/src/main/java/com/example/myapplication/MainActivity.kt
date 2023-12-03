package com.example.checkersgame

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridLayout = findViewById<GridLayout>(R.id.gridLayout)

        // Ініціалізація кнопок дошки
        for (row in 0 until 8) {
            for (col in 0 until 8) {
                val button = Button(this).apply {
                    setBackgroundColor(if ((row + col) % 2 == 0) Color.WHITE else Color.BLACK)
                    setOnClickListener { onCellClicked(this, row, col) }
                }
                gridLayout.addView(button, GridLayout.LayoutParams().apply {
                    rowSpec = GridLayout.spec(row)
                    columnSpec = GridLayout.spec(col)
                    width = 0
                    height = 0
                    setMargins(1, 1, 1, 1)
                    columnWeight = 1F
                    rowWeight = 1F
                })
            }
        }
    }

    private fun onCellClicked(view: View, row: Int, col: Int) {
        (view as Button).text = "X"
    }

    class MainActivity : AppCompatActivity() {
        private val game = CheckersGame()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

        }
        private fun onCellClicked(row: Int, col: Int) {

        }
    }

}
