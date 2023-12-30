package may.hamidov.policequiz.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import may.hamidov.policequiz.MainActivity
import may.hamidov.policequiz.R
import may.hamidov.policequiz.utils.Constants

class ResultActivity : AppCompatActivity() {
    private lateinit var textViewScore: TextView
    private lateinit var textViewName: TextView
    private lateinit var finishButton: Button
    private lateinit var congrat: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textViewScore = findViewById(R.id.textview_score)
        textViewName = findViewById(R.id.textview_name)
        finishButton = findViewById(R.id.finish_button)
        congrat = findViewById(R.id.tv_congratulations)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val score = intent.getIntExtra(Constants.SCORE,0)
        val name = intent.getStringExtra(Constants.USER_NAME)
        val congrats = intent.getStringExtra(Constants.CONGRAT)


        textViewScore.text = "Ты ответил(a) правильно на $score вопросов из $totalQuestions"
        textViewName.text = name
        if (score > 15) {
            congrat.text = "Поздравляю, ЗАЧЁТ!"
        } else {
            congrat.text = "К сожалению вы не сдали зачёт, попробуйте ещё раз!"
        }

        finishButton.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}