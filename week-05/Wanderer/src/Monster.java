public class Monster extends Character {

    String picMonster;
    int monsterLevel;
    int monsterId;

    public Monster(int monsterId) {
//        maxHP = 2 * level * d6.dice();
//        defend = (level / 2) d6.dice();
//        strike = level * d6.dice();
        this.monsterId = monsterId;
        this.posX = (int) (10.0 * Math.random());
        this.posY = (int) (10.0 * Math.random());
        this.picMonster = "Assets/skeleton.png";
    }

}