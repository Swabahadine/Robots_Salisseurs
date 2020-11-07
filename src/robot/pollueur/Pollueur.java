package robot.pollueur;

import monde.Monde;
import robot.Robot;
import utils.Utiles;

public abstract class Pollueur extends Robot {
    public Pollueur(int coordI, int coordJ) {
        super(coordI, coordJ);
    }

    @Override
    public void action(Monde m) {
        int r = Utiles.getRandomNumberInRange(0, 100);
        if (r <= getProbabilite()) {
            m.putPapier(getCoordI(), getCoordJ());
            String log = String.format(
                    "%s a DEPOSE un pipier gras de la case (%d,%d)", toString(), this.getCoordI(), this.getCoordJ());
            System.out.println(log);
        }
    }

    protected abstract int getProbabilite();

}
