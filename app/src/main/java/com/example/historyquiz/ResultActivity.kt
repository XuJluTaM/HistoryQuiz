package com.example.historyquiz

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val score = intent.getIntExtra("score", 0)
        val resultText = findViewById<TextView>(R.id.result_text)
        val finishButton = findViewById<Button>(R.id.finish_button)

        val resultDescription = when {
            score == 500 -> "Отличный знаток истории!"
            score >= 400 -> "Хороший знаток истории."
            score >= 300 -> "Удовлетворительный уровень знаний."
            score >= 200 -> "Знания требуют улучшения."
            else -> "Низкий уровень знаний."
        }

        resultText.text = "Ваш результат: $score\n$resultDescription"

        finishButton.setOnClickListener {
            finish()
        }
    }
}
