package robot.pollueur;

import monde.Monde;
import utils.Utiles;

public class PollueurIdiot extends Pollueur {
    private final int probabilite = 20; // en pourcentage
    private final int LEFT = 0;
    private final int TOP = 1;
    private final int RIGHT = 2;
    private final int BOTTOM = 3;

    public PollueurIdiot(int coordI, int coordJ) {
        super(coordI, coordJ);
    }

    @Override
    public void move(Monde m) {
        int coordI = this.getCoordI();
        int coordJ = this.getCoordJ();

        int choixDeplacement = Utiles.getRandomNumberInRange(0, 3);
        switch (choixDeplacement){
            case LEFT:
                if (m.isMoveToLeftPossible(coordI, coordJ)){
                    moveToLeft();
                }
                else {
                    moveToRight();
                }
                break;
            case TOP:
                if (m.isMoveToTopPossible(coordI, coordJ)){
                    moveToTop();
                }
                else {
                    moveToBottom();
                }
                break;
            case RIGHT:
                if (m.isMoveToRightPossible(coordI, coordJ)){
                    moveToRight();
                }
                else {
                    moveToLeft();
                }
                break;
            case BOTTOM:
                if (m.isMoveToBottomPossible(coordI, coordJ)){
                    moveToBottom();
                }
                else {
                    moveToTop();
                }
                break;
        }
    }

    @Override
    protected int getProbabilite() {
        return probabilite;
    }



    @Override
    public String toString() {
        return "I" + getNumeroSerie();
    }
}
