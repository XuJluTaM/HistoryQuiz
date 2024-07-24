package com.example.historyquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuestionActivity : AppCompatActivity() {

    private val questions = listOf(
        Question("Какое событие произошло в 1812 году?", listOf("Отечественная война", "Крымская война", "Русско-японская война"), 0),
        Question("Кто был первым императором России?", listOf("Пётр I", "Иван IV", "Николай I"), 0),
        Question("Когда был принят Закон о свободе крестьян?", listOf("1861", "1825", "1917"), 0),
        Question("Как называется период правления Александра III?", listOf("Реакция", "Либерализм", "Модернизация"), 0),
        Question("Кто был последним российским императором?", listOf("Николай II", "Александр III", "Пётр I"), 0)
    )

    private var currentQuestionIndex = 0
    private var totalScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val questionText = findViewById<TextView>(R.id.question_text)
        val option1 = findViewById<RadioButton>(R.id.option1)
        val option2 = findViewById<RadioButton>(R.id.option2)
        val option3 = findViewById<RadioButton>(R.id.option3)
        val optionsGroup = findViewById<RadioGroup>(R.id.options_group)
        val submitButton = findViewById<Button>(R.id.submit_button)

        displayQuestion()

        submitButton.setOnClickListener {
            val selectedOptionIndex = optionsGroup.indexOfChild(findViewById(optionsGroup.checkedRadioButtonId))
            if (selectedOptionIndex == questions[currentQuestionIndex].correctAnswerIndex) {
                totalScore += 100
            }

            if (currentQuestionIndex < questions.size - 1) {
                currentQuestionIndex++
                displayQuestion()
            } else {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("score", totalScore)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun displayQuestion() {
        val question = questions[currentQuestionIndex]
        findViewById<TextView>(R.id.question_text).text = question.text
        findViewById<RadioButton>(R.id.option1).text = question.options[0]
        findViewById<RadioButton>(R.id.option2).text = question.options[1]
        findViewById<RadioButton>(R.id.option3).text = question.options[2]
    }
}
