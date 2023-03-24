package com.dogukanincee.mvvm_template

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.spyk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
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
     * The [InstantTaskExecutorRule] to ensure that the LiveData updates instantly.
     */
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    /**
     * Sets up the [viewModel] instance for the test.
     */
    @Before
    fun setUp() {
        viewModel = spyk(ViewModel())
    }

    /**
     * Tests the [ViewModel.setMessage] function.
     */
    @Test
    fun test_setMessage_setsMessageValue() {
        // Given
        val message = "Test message"
        // When
        viewModel.setMessage(message)
        // Then
        assertEquals(message, viewModel.message.value)
    }
}