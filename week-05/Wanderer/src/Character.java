//every character has a (max and current) health point (HP), a defend (DP) and strike point (SP)
//        these values can change during the game
//        when a character's health point is 0 or below, it is dead
//        it disappears from the area
//        if its the hero, it is the end of the game

import java.awt.*;

public class Character extends PositionedImage {
    int maxHP;
    int currentHP;
    int defend;
    int strike;
    int posX;
    int posY;
    Dice d6;
    String defaultPic;

public Character(String filename, int posX, int posY) {
    super(filename, posX, posY);
    d6 = new Dice();
    this.posX = posX;
    this.posY = posY;
}


    public void posGen() {
        this.posY = (int) (10.0 * Math.random());
        this.posX = (int) (10.0 * Math.random());
    }

    public void draw(Graphics graphics) {
        if (image != null) {
            graphics.drawImage(image, posX * SIZE, posY * SIZE, null);
        }
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getDefend() {
        return defend;
    }

    public int getStrike() {
        return strike;
    }
}
