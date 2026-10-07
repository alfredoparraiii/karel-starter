import stanford.karel.*;

/*
 * MyKarel.java
 *
 * This is your robot. You are going to edit this file in class.
 *
 * Karel understands exactly four commands. That is not a simplification
 * to go easy on you; it is genuinely all there is:
 *
 *     move();          walk forward one square
 *     turnLeft();      rotate 90 degrees to the left
 *     pickBeeper();    pick up a beeper from the square you are standing on
 *     putBeeper();     put a beeper down on the square you are standing on
 *
 * The empty parentheses are required. move without them is not a command,
 * it is a typo, and the compiler will tell you so at length.
 *
 * There is no turnRight(). You will find that annoying for about ten seconds
 * and then you will work out what to do about it.
 */

public class MyKarel extends Karel {
    // Load DoubleBeepersKarel.w: start one square west of the pile, facing east.
    // The square east of the pile must be empty and reachable. Karel needs
    // at least one spare beeper in the bag for each beeper in the pile.
    public void run() {
        move();
        doubleBeepers();
    }

    // Start and finish on the original pile, facing east.
    private void doubleBeepers() {
        // Remove one original beeper and put two on the temporary square.
        // Keeping the new beepers separate lets the original pile run out.
        while (beepersPresent()) {
            pickBeeper();
            move();
            putBeeper();
            putBeeper();
            turnAround();
            move();
            turnAround();
        }

        // Move the doubled pile back to its original square.
        move();
        turnAround();
        while (beepersPresent()) {
            pickBeeper();
            move();
            putBeeper();
            turnAround();
            move();
            turnAround();
        }
        move();
        turnAround();
    }

    private void turnAround() {
        turnLeft();
        turnLeft();
    }
}
