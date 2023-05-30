import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @org.junit.jupiter.api.Test
    void checkLeapYear() {
        assertEquals(false, Main.checkLeapYear(1700));
    }

    @org.junit.jupiter.api.Test
    void testLeapYear() {
        assertEquals(true, Main.isLeapYear(2020));
        assertEquals(false, Main.isLeapYear(1900));
        assertEquals(true, Main.isLeapYear(2400));
    }
}
