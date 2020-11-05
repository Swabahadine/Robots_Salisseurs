package monde;

import pile.ListeLIFO;
import robot.Robot;

import java.util.Arrays;
import java.util.List;

public class Monde implements MondeInterface {
    private final int dimension;
    private final ListeLIFO<PapierGras>[][] terrain;
    private List<Robot> robots;
    private int tour = 0;

    public Monde(int dimension, List<Robot> robots) {
        this.dimension = dimension;
        this.robots = robots;
        terrain = new ListeLIFO[dimension][dimension];
        for (int i = 0; i < dimension; i++){
            for (int j = 0; j < dimension; j++){
                terrain[i][j] = new ListeLIFO();
            }
        }
    }

    @Override
    public void nextRound() {
        robots.get(tour).action(this);
        robots.get(tour).move(this);
        tour = (tour + 1) % robots.size();
    }

    @Override
    public int getDimension() {
        return dimension;
    }

    @Override
    public String toString() {
        String t = "";
        int i = 0;
        for (ListeLIFO[] ligne : terrain){
            int j = 0;
            for (ListeLIFO caseTerrain: ligne){
                int idRobot = -1;
                for (Robot robot: robots){
                    if (robot.getCoordI() == i && robot.getCoordJ() == j){
                        idRobot = robot.getNumeroSerie();
                        break;
                    }
                }
                if (idRobot >= 0){
                    t+= "R" + idRobot+ " ";
                }
                else t+= caseTerrain.toString() + "  ";
                j++;
            }
            i++;
            t+="\n";
        }
        return t;
    }

    public void putPapier(int i, int j){
        ListeLIFO<PapierGras> pile = terrain[i][j];
        pile.push(new PapierGras());
    }

    public void removePapier(int i, int j){
        ListeLIFO<PapierGras> pile = terrain[i][j];
        if (!pile.isEmpty()) {
            pile.pop();
        }
    }

    public boolean isMoveToLeftPossible(int i, int j){
        return j > 0;
    }

    public boolean isMoveToRightPossible(int i, int j){
        return j < dimension - 1;
    }

    public boolean isMoveToTopPossible(int i, int j){
        return i > 0;
    }

    public boolean isMoveToBottomPossible(int i, int j){
        return i < dimension - 1;
    }


}
