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
        robots.stream().forEach(robot -> {
            System.out.println();
            robot.move(this);
            robot.action(this);
        });
        System.out.println();

    }

    @Override
    public int getDimension() {
        return dimension;
    }

    public int numberOfPapierGrasInCase(int i, int j) {
        return terrain[i][j].size();
    }

    private String indiceCol(){
        String DECAL = "    ";
        String strCol = DECAL;
        for (int i = 0; i < getDimension(); i++){
            if (i < 10) strCol+= i + "  ";
            else strCol+= i + " ";
        }
        strCol+="\n" + DECAL;
        for (int i = 0; i < getDimension(); i++){
            strCol+="---";
        }
        return strCol+"\n";
    }

    private String indiceRow(int i){
        if (i < 10){
            return " " + i + " |";
        }
        return i + " |";
    }

    @Override
    public String toString() {
        String t = indiceCol();
        int i = 0;
        for (ListeLIFO[] ligne : terrain){
            t += indiceRow(i);
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
