package io.rohit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("When running MathUtilsTest")
class MathUtilsTest {

    private MathUtils mathUtils;
    private TestInfo testInfo;
    private TestReporter testReporter;

    @BeforeEach
    void init(TestInfo testInfo,TestReporter testReporter){
        mathUtils = new MathUtils();
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        testReporter.publishEntry("Running "+testInfo.getDisplayName() + " with tags "+testInfo.getTags());
    }

    @Nested
    @DisplayName("add method ")
    class AddTest {
        @Test
        @DisplayName("when adding two positive number")
        void testAddPositive(){
                assertEquals(5,mathUtils.add(2,3),"should returns the right sum");
        }

        @Test
        @DisplayName("Testing add Method for negative")
        void testAddNegative(){
            int expected = 3;
            int actual = mathUtils.add(5,-2);
            assertEquals(expected,actual,() ->"should returns " + expected + " but returns "+actual);
        }
    }

    @Test
    void testComputeCircleArea(){
        assertEquals(314.1592653589793,mathUtils.computeCircleArea(10),"Should return area of cirlce");
    }

    @Test
    void testDivide(){
        boolean isServerUp = false;
        assumeTrue(isServerUp);
        assertThrows(ArithmeticException.class,()-> mathUtils.divide(1,0),"Divide by zero shud throw");
    }


    @Test
    @DisplayName("Multiply method")
    @Tag("Circle")
    void testMultiply(){

       assertAll(
               ()-> assertEquals(4, mathUtils.multiply(2,2)),
               ()-> assertEquals(0, mathUtils.multiply(2,0)),
               ()-> assertEquals(-2,mathUtils.multiply(-1,2))
       );

    }

    @Test
    @Disabled
    @DisplayName("TTD method. Should not run")
    void testDisabled(){
        fail("This test should be disabled");
    }

}