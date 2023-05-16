package be.intecbrussel.eatables;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class IceRocketTest {
    //properties
    //required for testing void methods
    ByteArrayOutputStream outContent;
    PrintStream originalOut;


    //pre-test
    @BeforeEach
    void beforeEach() {
        //required for testing void methods
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }


    //post-test
    @AfterEach
    void afterEach() {
        //required for testing void methods
        System.setOut(originalOut);
    }


    //testing methods
    @Test
    @DisplayName("IceRocket - eat()")
    void shouldReturnEqualsWhenCallingEatMethod() {
        IceRocket iceRocket = new IceRocket();
        iceRocket.eat();
        assertEquals("Eating an icerocket", outContent.toString());
    }
}