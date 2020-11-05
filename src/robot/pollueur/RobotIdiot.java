package robot.pollueur;

import monde.Monde;
import robot.Robot;
import robot.RobotInterface;
import utils.Utiles;

public class RobotIdiot extends Robot {
    private final double probabilite = 20;
    private final int LEFT = 0;
    private final int TOP = 1;
    private final int RIGHT = 2;
    private final int BOTTOM = 3;

    public RobotIdiot(int coordI, int coordJ) {
        super(coordI, coordJ);
    }

    @Override
    public void move(Monde m) {
        int coordI = this.getCoordI();
        int coordJ = this.getCoordJ();

        int choixDeplacement = Utiles.getRandomNumberInRange(0, 3);
        System.out.println("Move Robot idiot, id " + getNumeroSerie());
        System.out.println("Coord i, j " + this.getCoordI() + " "+ this.getCoordJ());
        switch (choixDeplacement){
            case LEFT:
                System.out.println("choix LEFT");
                if (m.isMoveToLeftPossible(coordI, coordJ)){
                    moveToLeft();
                }
                else {
                    moveToRight();
                }
                break;
            case TOP:
                System.out.println("choix TOP");
                if (m.isMoveToTopPossible(coordI, coordJ)){
                    moveToTop();
                }
                else {
                    moveToBottom();
                }
                break;
            case RIGHT:
                System.out.println("choix RIGHT");
                if (m.isMoveToRightPossible(coordI, coordJ)){
                    moveToRight();
                }
                else {
                    moveToLeft();
                }
                break;
            case BOTTOM:
                System.out.println("choix BOTTOM");
                if (m.isMoveToBottomPossible(coordI, coordJ)){
                    moveToBottom();
                }
                else {
                    moveToTop();
                }
                break;
        }
        System.out.println("Coord i, j " + this.getCoordI() + " "+ this.getCoordJ());

    }

    @Override
    public void action(Monde m) {
        int r = Utiles.getRandomNumberInRange(0, 100);
        if (r <= probabilite) {
            System.out.println("Action Robot idiot");
            m.putPapier(getCoordI(), getCoordJ());
        }
    }
}
