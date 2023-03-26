package com.dogukanincee.mvvm_template

import com.dogukanincee.mvvm_template.model.Message
import com.dogukanincee.mvvm_template.view_model.ViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

/**
 * Test class for the [ViewModel] class.
 */
@RunWith(MockitoJUnitRunner::class)
class ViewModelTest {

    /**
     * The [ViewModel] instance to be tested.
     */
    private lateinit var viewModel: ViewModel


    /**
     * A mocked [Message] object to be used in tests.
     */
    @Mock
    lateinit var mockMessage: Message

    /**
     * Sets up the [viewModel] instance for the test.
     */
    @Before
    fun setUp() {
        viewModel = ViewModel()
    }

    /**
     * Tests the [ViewModel.setMessage] function when the message is not empty.
     */
    @Test
    fun `test set message with non-empty text`() {
        val message = "Hello, World!"
        viewModel.setMessage(message)
        assertEquals(message, viewModel.message.value?.text)
    }

    /**
     * Tests the [ViewModel.setMessage] function when the message is empty.
     */
    @Test
    fun `test set message with empty text`() {
        val message = ""
        viewModel.setMessage(message)
        assertEquals(message, viewModel.message.value?.text)
    }

    /**
     * Tests the [ViewModel.setMessage] function when the message is not null and not empty.
     */
    @Test
    fun `test set message with non-null and non-empty text`() {
        val message = "Hello world!"
        viewModel.setMessage(message)
        assertEquals(message, viewModel.message.value?.text)
    }

    /**
     * Tests the [ViewModel.setMessage] function with a mocked [Message] object that throws an exception.
     */
    @Test(expected = Exception::class)
    fun `test set message with mocked Message object that throws an exception`() {
        `when`(mockMessage.text).thenThrow(Exception())
        viewModel.setMessage(mockMessage.text)
    }

    /**
     * Test case for verifying that the ViewModel updates the message correctly.
     */
    @Test
    fun `test ViewModel updates message`() {
        val viewModel = ViewModel()
        val message = "Hello World"
        viewModel.setMessage(message)
        assertEquals(message, viewModel.message.value!!.text)
    }
}