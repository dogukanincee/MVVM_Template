package com.dogukanincee.mvvm_template

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dogukanincee.mvvm_template.view.MainActivity
import com.dogukanincee.mvvm_template.view_model.ViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Test class for the [MainActivity] class.
 */
class MainActivityTest {

    /**
     * The [ViewModel] instance to be tested.
     */
    @Mock
    lateinit var viewModel: ViewModel

    /**
     * The [InstantTaskExecutorRule] to ensure that the LiveData updates instantly.
     */
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    /**
     * Sets up the [viewModel] instance for the test.
     */
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = ViewModel()
    }

    /**
     * Tests the [MainActivity.getRandomText] function.
     */
    @Test
    fun test_getRandomText_returnsRandomText() {
        val texts = listOf("Merhaba", "Hello", "Hallo", "Bonjour", "Hola", "こんにちは", "안녕하세요")
        val randomText = MainActivity().getRandomText()
        assertTrue(texts.contains(randomText))
    }

    /**
     * Tests the [ViewModel.setMessage] function when the message is not null.
     */
    @Test
    fun test_setMessage_withNonNullText() {
        val message = "Test message"
        viewModel.setMessage(message)
        assertTrue(viewModel.message.value?.text == message)
    }

    /**
     * Tests the [ViewModel.setMessage] function with an empty message.
     */
    @Test
    fun test_setMessage_withEmptyText() {
        val message = ""
        viewModel.setMessage(message)
        assertTrue(viewModel.message.value?.text.isNullOrEmpty())
    }

    /**
     * Tests the [ViewModel.setMessage] function with a long message.
     */
    @Test
    fun test_setMessage_withLongText() {
        val message =
            "This is a long message that should exceed the maximum length limit of the message, which is 50 characters. This test case is added to ensure that the message is truncated to 50 characters."
        viewModel.setMessage(message)
        assertEquals(188, viewModel.message.value?.text?.length)
    }
}