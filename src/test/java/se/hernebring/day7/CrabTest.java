package se.hernebring.day7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CrabTest {

    @Test
    void threePositionsConsumesOne() {
        assertEquals(1, Crab.calc(new int[]{0, 1, 1}, false));
    }

    @Test
    void fivePositionsConsumesTwo() {
        assertEquals(2, Crab.calc(new int[]{2, 1, 1, 2, 1}, false));
    }

    @Test
    void threePositionsConsumesFifteen() {
        assertEquals(15, Crab.calc(new int[]{16,1,2}, false));
    }

    @Test
    void fivePositionsConsumesFifteen() {
        assertEquals(19, Crab.calc(new int[]{16,1,2,0,4}, false));
    }

    @Test
    void sevenPositionsConsumesTwentyFour() {
        assertEquals(24, Crab.calc(new int[]{16,1,2,0,4,2,7}, false));
    }

    @Test
    void tenPositionsConsumesThirtySeven() {
        assertEquals(37, Crab.calc(new int[]{16,1,2,0,4,2,7,1,2,14}, false));
    }

    @Test
    void tenPositions2ConsumesHundredSixtyEight() {
        assertEquals(168, Crab.calc(new int[]{16,1,2,0,4,2,7,1,2,14}, true));
    }

}
