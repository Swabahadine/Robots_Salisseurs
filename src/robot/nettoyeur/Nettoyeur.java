package robot.nettoyeur;

import monde.Monde;
import robot.Robot;

public abstract class Nettoyeur extends Robot {
    public Nettoyeur(int coordI, int coordJ) {
        super(coordI, coordJ);
    }

    @Override
    public void action(Monde m) {
        boolean isRemoved = m.removePapier(this.getCoordI(), this.getCoordJ());
        if (isRemoved){
            String log = String.format("%s a RETIRÉ un pipier gras de la case (%d,%d)", toString(), this.getCoordI(), this.getCoordJ());
            System.out.println(log);
        }
    }

}
