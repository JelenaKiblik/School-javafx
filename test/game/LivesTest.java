package game;

import game.elements.Lives;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;


class LivesTest {
    /**
     * Lives class for testing.
     */
    private Lives lives = new Lives();

    /**
     * Error message for testing.
     */
    private String error = "Negative not possible!";

    /**
     * Tests for lives lost by one point.
     */
    @Test
    public void removeLiveByOne() {
        lives.setLivesCount();
        lives.loseLife();
        assertEquals(1, lives.getLivesCount());
    }

    /**
     * Tests for lives lost by two points.
     */
    @Test
    public void removeLiveByTwo() {
        lives.setLivesCount();
        lives.loseLife();
        lives.loseLife();
        assertEquals(0, lives.getLivesCount());
    }

    /**
     * Tests for error message.
     */
    @Test
    public void removeLiveCheckNegative() {
        lives.setLivesCount();
        lives.loseLife();
        lives.loseLife();
        lives.loseLife();
        assertEquals("Negative not possible!", error);
    }
}
