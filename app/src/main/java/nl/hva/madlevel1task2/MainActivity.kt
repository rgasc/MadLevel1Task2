package nl.hva.madlevel1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import nl.hva.madlevel1task2.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var correctAnswers: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }

    /**
     * Setup the onClick listener for the submit button
     */
    private fun initListeners() {
        binding.submitButton.setOnClickListener { checkCorrectAnswers() }
    }

    /**
     * Check the amount of correct answers and store it in the correctAnswers variable
     */
    private fun checkCorrectAnswers() {
        if (binding.answer1.text.toString().toLowerCase(Locale.getDefault()) == "t") correctAnswers++
        if (binding.answer2.text.toString().toLowerCase(Locale.getDefault()) == "f") correctAnswers++
        if (binding.answer3.text.toString().toLowerCase(Locale.getDefault()) == "f") correctAnswers++
        if (binding.answer4.text.toString().toLowerCase(Locale.getDefault()) == "f") correctAnswers++

        showCorrectAnswers()
        correctAnswers = 0
    }

    /**
     * Print toast with the amount of correct answers
     */
    private fun showCorrectAnswers() {
        Toast.makeText(this, getString(R.string.correct_answers, correctAnswers), Toast.LENGTH_SHORT).show()
    }
}