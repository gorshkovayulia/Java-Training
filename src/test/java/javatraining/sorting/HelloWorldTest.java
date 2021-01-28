package javatraining.sorting;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HelloWorldTest {
    @Test void passesNameIntoGreeting() {
        HelloWorld sut = new HelloWorld();
        String actualResult = sut.greet("World");
        assertEquals(actualResult, "Hello World!");
    }
}