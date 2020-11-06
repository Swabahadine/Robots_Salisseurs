package monde;

import pile.ListeLIFO;
import robot.Robot;

import java.util.List;

public class Monde implements MondeInterface {
    private final int dimension;
    private final ListeLIFO[][] terrain;
    private List<Robot> robots;
    private int tour = 0;

    public Monde(int dimension, List<Robot> robots) {
        this.dimension = dimension;
        this.robots = robots;
        terrain = new ListeLIFO[dimension][dimension];
        // initialise les cases du terrain à une pile vide
        for (int i = 0; i < dimension; i++){
            for (int j = 0; j < dimension; j++){
                terrain[i][j] = new ListeLIFO<PapierGras>();
            }
        }
    }

    @Override
    public void nextRound() {
        Robot robot = robots.get(tour);
        System.out.println("C'est au tour de " + robot);
        robot.move(this);
        robot.action(this);
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
                String caseStr = caseTerrain.toString() + "  ";
                for (Robot robot: robots){
                    if (robot.getCoordI() == i && robot.getCoordJ() == j){
                        caseStr = robot.toString() + " ";
                        break;
                    }
                }
                t+= caseStr;
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

    public boolean removePapier(int i, int j){
        ListeLIFO<PapierGras> pile = terrain[i][j];
        if (!pile.isEmpty()) {
            pile.pop();
            return true;
        }
        return false;
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
