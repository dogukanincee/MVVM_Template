package com.dogukanincee.mvvm_template.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dogukanincee.mvvm_template.model.Message

/**
 * ViewModel class that provides the data for the UI layer and survives configuration changes.
 * This class extends the ViewModel class provided by the Android Architecture Components.
 */
open class ViewModel : ViewModel() {

    /**
     * MutableLiveData variable for holding the message data. This variable is private to ensure that
     * it can only be modified within this class.
     */
    private val _message = MutableLiveData<Message>()

    /**
     * LiveData variable that exposes the message data to the UI layer. This variable is public and
     * read-only to ensure that it can only be read and not modified from the UI layer.
     */
    val message: LiveData<Message> get() = _message

    /**
     * Function for setting the value of the message data. This function takes a string argument
     * and sets the value of the _message variable to that string.
     * @param message the message string to be set
     */
    fun setMessage(text: String) {
        val message = Message(text)
        _message.value = message
    }
}
