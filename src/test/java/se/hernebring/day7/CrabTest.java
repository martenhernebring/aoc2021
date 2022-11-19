package se.hernebring.day7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CrabTest {

    @Test
    void threePositionsConsumesOne() {
        assertEquals(1, Crab.calc(new int[]{0, 1, 1}));
    }

    @Test
    void fivePositionsConsumesTwo() {
        assertEquals(2, Crab.calc(new int[]{2, 1, 1, 2, 1}));
    }

    @Test
    void threePositionsConsumesFifteen() {
        assertEquals(15, Crab.calc(new int[]{16,1,2}));
    }

    @Test
    void fivePositionsConsumesFifteen() {
        assertEquals(19, Crab.calc(new int[]{16,1,2,0,4}));
    }

    @Test
    void sevenPositionsConsumesTwentyFour() {
        assertEquals(24, Crab.calc(new int[]{16,1,2,0,4,2,7}));
    }

    @Test
    void tenPositionsConsumesThirtySeven() {
        assertEquals(37, Crab.calc(new int[]{16,1,2,0,4,2,7,1,2,14}));
    }
}
