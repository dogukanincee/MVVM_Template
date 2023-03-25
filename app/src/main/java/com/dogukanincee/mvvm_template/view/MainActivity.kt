package com.dogukanincee.mvvm_template.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dogukanincee.mvvm_template.R
import com.dogukanincee.mvvm_template.view_model.ViewModel
import kotlin.random.Random

/**
 * This activity class is the main entry point for the application.
 * It initializes the ViewModel and the UI elements, and observes the LiveData variable to update the UI.
 */
class MainActivity : AppCompatActivity() {

    // The ViewModel instance for this activity
    lateinit var viewModel: ViewModel

    // The TextView element that displays the message
    lateinit var messageTextView: TextView

    /**
     * This method is called when the activity is created.
     * It initializes the ViewModel and the UI elements, and observes the LiveData variable to update the UI.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the ViewModel
        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        // Initialize the messageTextView
        messageTextView = findViewById(R.id.messageTextView)

        // Observe the LiveData variable and update the messageTextView when it changes
        viewModel.message.observe(this) { message ->
            messageTextView.text = message.text
        }
    }

    /**
     * This method is called when the "Update Message" button is clicked.
     * It calls the setMessage() method in the ViewModel to update the message.
     */
    fun updateMessage(view: View) {
        val message = getRandomText()
        viewModel.setMessage(message)
        Log.d("MainActivity", "updateMessage(): $message")
    }

    /**
     * Returns a randomly selected greeting text from a list of available texts.
     * The list of available texts includes "Merhaba", "Hello", "Hallo", "Bonjour", "Hola", "こんにちは", and "안녕하세요".
     * @return a randomly selected greeting text
     */
    fun getRandomText(): String {
        val texts = listOf("Merhaba", "Hello", "Hallo", "Bonjour", "Hola", "こんにちは", "안녕하세요")
        return texts[Random.nextInt(texts.size)]
    }
}