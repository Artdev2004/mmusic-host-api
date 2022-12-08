package com.etec.mmusic.exception;

import com.etec.mmusic.controller.response.AttendantResponse;
import com.etec.mmusic.controller.response.UserTokenResponse;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ErrorMessageTest {

    @Test
    void getStatusCode() {
        ErrorMessage errorMessage = new ErrorMessage(400, new Date(), "", "");
        errorMessage.setStatusCode(400);
        assertEquals(400, errorMessage.getStatusCode());
    }


    @Test
    void getTimestamp() {
        Date date = new Date();
        ErrorMessage errorMessage = new ErrorMessage(0, date, "", "");
        errorMessage.setTimestamp(date);
        assertEquals(date, errorMessage.getTimestamp());
    }

    @Test
    void getMessage() {
        String message = "message";
        ErrorMessage errorMessage = new ErrorMessage(0, new Date(), message, "");
        errorMessage.setMessage(message);
        assertEquals(message, errorMessage.getMessage());
    }

    @Test
    void getDescription() {
        String description = "description";
        ErrorMessage errorMessage = new ErrorMessage(0, new Date(), "", description);
        errorMessage.setDescription(description);
        assertEquals(description, errorMessage.getDescription());
    }

    @Test
    void testEquals() {
        Date date = new Date();
        ErrorMessage errorMessage1 = new ErrorMessage(400, date, "message", "description");
        ErrorMessage errorMessage2 = new ErrorMessage(400, date, "message", "description");

        boolean expected = errorMessage1.equals(errorMessage2);

        assertTrue(expected);

    }

    @Test
    void canEqual() {
        Date date = new Date();
        ErrorMessage errorMessage1 = new ErrorMessage(400, date, "message", "description");
        ErrorMessage errorMessage2 = new ErrorMessage(400, date, "message", "description");

        boolean expected = errorMessage1.canEqual(errorMessage2);

        assertTrue(expected);

    }

    @Test
    void testHashCode() {
        Date date = new Date();
        ErrorMessage errorMessage1 = new ErrorMessage(400, date, "message", "description");
        ErrorMessage errorMessage2 = new ErrorMessage(400, date, "message", "description");

        boolean expected = errorMessage1.hashCode() == errorMessage2.hashCode();

        assertTrue(expected);

    }

    @Test
    void testToString() {
        Date date = new Date();
        ErrorMessage errorMessage1 = new ErrorMessage(400, date, "message", "description");
        ErrorMessage errorMessage2 = new ErrorMessage(400, date, "message", "description");

        String expected1 = errorMessage1.toString();
        String expected2 = errorMessage2.toString();

        assertEquals(expected1, expected2);

    }

    @Test
    void builder() {
        Date date = new Date();
        ErrorMessage errorMessage = ErrorMessage.builder()
                .statusCode(400)
                .timestamp(date)
                .message("message")
                .description("description")
                .build();

        assertEquals(400, errorMessage.getStatusCode());
        assertEquals(date, errorMessage.getTimestamp());
        assertEquals("message", errorMessage.getMessage());
        assertEquals("description", errorMessage.getDescription());

    }

    @Test
    void testErrorMessageBuilderToString() {
        String errorMessageBuilder  = new ErrorMessage.ErrorMessageBuilder().toString();

        String errorMessageBuilderExpected = new ErrorMessage.ErrorMessageBuilder().toString();

        assertEquals(errorMessageBuilderExpected, errorMessageBuilder);
    }

    @Test
    void testErrorMessageBuilderHashCode() {
        Date date = new Date();

        ErrorMessage.ErrorMessageBuilder builder1  = new ErrorMessage.ErrorMessageBuilder();
        builder1.statusCode(500);

        ErrorMessage.ErrorMessageBuilder builder2  = new ErrorMessage.ErrorMessageBuilder();
        builder2.message("message");

        ErrorMessage.ErrorMessageBuilder builder3  = new ErrorMessage.ErrorMessageBuilder();
        builder3.timestamp(date);

        ErrorMessage.ErrorMessageBuilder builder4  = new ErrorMessage.ErrorMessageBuilder();
        builder4.description("description");

        boolean statusCodeExpected =  builder1.statusCode(500).build().hashCode() ==  builder1.statusCode(500).build().hashCode();
        boolean messageExpected = builder2.message("message").build().hashCode() ==  builder2.message("message").build().hashCode();
        boolean dateExpected =  builder3.timestamp(date).build().hashCode() ==  builder3.timestamp(date).build().hashCode();
        boolean descriptionExpected = builder4.description("description").build().hashCode() ==  builder4.description("description").build().hashCode();


        assertTrue(statusCodeExpected);
        assertTrue(messageExpected);
        assertTrue(dateExpected);
        assertTrue(descriptionExpected);
    }
}