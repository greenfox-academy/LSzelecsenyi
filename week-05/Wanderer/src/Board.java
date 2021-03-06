import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Board extends JComponent implements KeyListener {

    int level = 1;
    Hero hero;
    Boss boss;
    ArrayList<Monster> monsters;
    int[][] board = new int[][]{
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 1, 1, 0},
                {0, 1, 1, 1, 0, 1, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 1, 0, 0, 0}
        };

    public Board() {
        hero = new Hero();
        boss = new Boss();
        monsters = new ArrayList<>();
        generateMonster(3);
        // set the size of your draw board
        setPreferredSize(new Dimension(720, 750));
        setVisible(true);

        while (board[boss.posY][boss.posX] != 0) {
            boss.posGen();
        }

        for (Character ch : monsters) {
            while (board[ch.posY][ch.posX] != 0) {
                ch.posGen();
            }
        }
    }

//    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        for (int column = 0; column < 10; column++) {
            for (int row = 0; row < 10; row++) {
                    Floor floor = new Floor(row, column);
                    Wall wall = new Wall(row, column);
                if (board[column][row] == 0) {
                    floor.draw(graphics);
                } else if (board[column][row] == 1) {
                    wall.draw(graphics);
                }
            }
        }
        hero.draw(graphics);
        boss.draw(graphics);
        for (int i = 0; i < monsters.size(); i++) {
            monsters.get(i).draw(graphics);
        hub(graphics);
        }


    }

    // To be a KeyListener the class needs to have these 3 methods in it
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    // But actually we can use just this one for our goals here
    @Override
    public void keyReleased(KeyEvent e) {
        // When the up or down keys hit, we change the position of our box
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            hero.turnUp(board);
        } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.turnDown(board);
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.turnRight(board);
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.turnLeft(board);
        }
        // and redraw to have a new picture with the new coordinates
        repaint();
    }

    public void generateMonster(int monsterNumber) {
        for (int i = 0; i < monsterNumber; i++) {
            this.monsters.add(new Monster(i-1));
        }
    }

//    Hero (Level 1) HP: 8/10 | DP: 8 | SP: 6

    public void hub(Graphics graphics) {
        StringBuilder sb = new StringBuilder();
            sb.append("Hero (Level " + getLevel() + ") HP: " + hero.getCurrentHP());
            sb.append("/" + hero.getMaxHP() + " | DP: " + hero.getDefend() + " | SP: " + hero.getStrike());
            String hub = sb.toString();
            graphics.setColor(Color.BLACK);
            graphics.setFont(new Font("Impact", Font.PLAIN, 22));
            graphics.drawString(hub, 12, 743);
    }

    public int getLevel() {
        return level;
    }
}