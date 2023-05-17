package be.intecbrussel.eatables;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MagnumTest {
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


    //constructors
    @Test
    @DisplayName("Magnum - no args constructor")
    void shouldReturnNotNullWhenCreatingInstanceWithNoArgsConstructor() {
        //when
        Magnum magnum = new Magnum();

        //then
        assertNotNull(magnum);
    }

    //all args
    @Test
    @DisplayName("Magnum - all args constructor")
    void shouldReturnNotNullWhenCreatingInstanceWithAllArgsConstructor() {
        //when
        Magnum magnum = new Magnum(Magnum.MagnumType.ALPINENUTS);

        //then
        assertNotNull(magnum);
    }


    //getters & setters
    @Test
    @DisplayName("Magnum - getType()")
    void shouldReturnEqualsWhenGettingMagnumType() {
        //given
        Magnum magnum = new Magnum();

        //then
        assertEquals(magnum.getType(), Magnum.MagnumType.MILKCHOCOLATE);
    }


    //custom methods
    @Test
    @DisplayName("Magnum - eat()")
    void shouldReturnEqualsWhenComparingMethodPrint() {
        Magnum magnum = new Magnum();
        magnum.eat();
        assertEquals("I'm eating milkchocolate", outContent.toString());
    }
}