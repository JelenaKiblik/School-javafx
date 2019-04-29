package game;

import game.elements.Pipes;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

    class PipesTest {

        /**
         * Image for the pipes.
         */
        private Image pipeImage = new Image(getClass().getResourceAsStream("/resources/pipe.png"));
        /**
         * Image view for the first pipe.
         */
        private ImageView pipeOne = new ImageView(pipeImage);
        /**
         * Image view for the second pipe.
         */
        private ImageView pipeTwo = new ImageView(pipeImage);
        /**
         * Image view for the third pipe.
         */
        private ImageView pipeThree = new ImageView(pipeImage);
        /**
         * Image view for the fourth pipe.
         */
        private ImageView pipeFour = new ImageView(pipeImage);

        /**
         * Pipes class for testing.
         */
        Pipes pipes = new Pipes();

        /**
         * Tests for the created image.
         */
        @Test
        public void makeFirstPipe() {
            pipeTwo.setRotate(180);
            pipeTwo.setX(600);
            pipeTwo.setY(0);
            pipeTwo.setFitWidth(100);
            pipeTwo.setFitHeight(140);
            assertEquals(pipes.getPipeTwo(), pipeTwo);
        }

        /**
         * Tests for the created image.
         */
        @Test
        public void makeSecondPipe() {
            pipeOne.setX(600);
            pipeOne.setY(350);
            pipeOne.setFitHeight(250);
            pipeOne.setFitWidth(100);
            assertEquals(pipes.getPipeOne(), pipeOne);
        }

        /**
         * Tests for the created image.
         */
        @Test
        public void makeThirdPipe() {
            pipeThree.setRotate(180);
            pipeThree.setX(600);
            pipeThree.setY(0);
            pipeThree.setFitWidth(100);
            pipeThree.setFitHeight(250);
            assertEquals(pipes.getPipeThree(), pipeThree);
        }

        /**
         * Tests for the created image.
         */
        @Test
        void makeFourthPipe() {
            pipeFour.setX(600);
            pipeFour.setY(400);
            pipeFour.setFitWidth(100);
            pipeFour.setFitHeight(200);
            assertEquals(pipes.getPipeFour(), pipeFour);
        }
    }
