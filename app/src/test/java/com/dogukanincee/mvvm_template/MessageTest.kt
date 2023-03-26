package com.dogukanincee.mvvm_template

import com.dogukanincee.mvvm_template.model.Message
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 *
This is a JUnit test class for the Message data class. It uses the MockK library to mock the
Message class and test its behavior in various scenarios.
 */
class MessageTest {

    @MockK
    lateinit var message: Message

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `test getMessageText when message text is empty`() {
        every { message.text } returns ""
        assertEquals("", message.text)
    }

    @Test
    fun `test getMessageText when message text is not empty`() {
        every { message.text } returns "Test message"
        assertEquals("Test message", message.text)
    }

    @Test
    fun `test setMessageText when setting an empty message text`() {
        message = Message("")
        assertEquals("", message.text)
    }

    @Test
    fun `test setMessageText when setting a non-empty message text`() {
        message = Message("Test message")
        assertEquals("Test message", message.text)
    }

    @Test
    fun `test equals method with different messages`() {
        val message1 = Message("Test message 1")
        val message2 = Message("Test message 2")
        assertEquals(false, message1 == message2)
    }

    @Test
    fun `test message with numbers`() {
        val message = Message("12345")
        assertEquals("12345", message.text)
    }

    @Test
    fun `test message with special characters`() {
        val message = Message("!@#$%^&*()")
        assertEquals("!@#$%^&*()", message.text)
    }

    @Test
    fun `test message with emojis`() {
        val message = Message("🐶🐾")
        assertEquals("🐶🐾", message.text)
    }

    @Test
    fun `test message with whitespace`() {
        val message = Message("   ")
        assertEquals("   ", message.text)
    }

    @Test
    fun `test message with newlines`() {
        val message = Message("Hello\nWorld")
        assertEquals("Hello\nWorld", message.text)
    }
}
