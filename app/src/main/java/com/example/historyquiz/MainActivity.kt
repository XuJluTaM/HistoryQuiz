package com.example.historyquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.start_button).setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra("score", 0)
            startActivity(intent)
        }
    }
}
