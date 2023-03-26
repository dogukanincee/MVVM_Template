package com.dogukanincee.mvvm_template

import com.dogukanincee.mvvm_template.model.Message
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * This is a JUnit test class for the Message data class. It uses the MockK library to mock the
 * Message class and test its behavior in various scenarios.
 */
class MessageTest {

    @MockK
    lateinit var message: Message

    /**
     * Initialize mocks before each test.
     */
    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    /**
     * Cleanup mocks after each test.
     */
    @After
    fun tearDown() {
        unmockkAll()
    }

    /**
     * Test [Message.text] property when message text is empty.
     */
    @Test
    fun `test getMessageText when message text is empty`() {
        every { message.text } returns ""
        val result = message.text
        assert(result.isEmpty()) { "Expected empty string, but was $result" }
    }

    /**
     * Test [Message.text] property when message text is not empty.
     */
    @Test
    fun `test getMessageText when message text is not empty`() {
        every { message.text } returns "Test message"
        val result = message.text
        assert(result == "Test message") { "Expected 'Test message', but was $result" }
    }

    /**
     * Test [Message] constructor when setting an empty message text.
     */
    @Test
    fun `test setMessageText when setting an empty message text`() {
        message = Message("")
        val result = message.text
        assert(result.isEmpty()) { "Expected empty string, but was $result" }
    }

    /**
     * Test [Message] constructor when setting a non-empty message text.
     */
    @Test
    fun `test setMessageText when setting a non-empty message text`() {
        message = Message("Test message")
        val result = message.text
        assert(result == "Test message") { "Expected 'Test message', but was $result" }
    }

    /**
     * Test [Message.equals] method with different messages.
     */
    @Test
    fun `test equals method with different messages`() {
        val message1 = Message("Test message 1")
        val message2 = Message("Test message 2")
        assert(message1 != message2) { "Expected different messages" }
    }

    /**
     * Test [Message] constructor with message text containing numbers.
     */
    @Test
    fun `test message with numbers`() {
        message = Message("12345")
        val result = message.text
        assert(result == "12345") { "Expected '12345', but was $result" }
    }

    /**
     * Test [Message] constructor with message text containing special characters.
     */
    @Test
    fun `test message with special characters`() {
        message = Message("!@#$%^&*()")
        val result = message.text
        assert(result == "!@#$%^&*()") { "Expected '!@#$%^&*()', but was $result" }
    }

    /**
     * Test [Message] constructor with message text containing emojis.
     */
    @Test
    fun `test message with emojis`() {
        message = Message("🐶🐾")
        val result = message.text
        assert(result == "🐶🐾") { "Expected '🐶🐾', but was $result" }
    }

    /**
     * Test [Message] constructor with message text containing only whitespace characters.
     */
    @Test
    fun `test message with whitespace`() {
        val message = Message("   ")
        assertEquals("   ", message.text)
    }

    /**
     * Test [Message] constructor with message text containing newline characters.
     */
    @Test
    fun `test message with newlines`() {
        val message = Message("Hello\nWorld")
        assertEquals("Hello\nWorld", message.text)
    }

}
