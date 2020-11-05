package monde;

import pile.ListeLIFO;
import robot.Robot;
import robot.nettoyeur.NettoyeurNormal;
import robot.pollueur.RobotIdiot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMonde {
    public static void main(String[] args) {
        List<Robot> robots = Arrays.asList(
                new RobotIdiot(4,6),
                new RobotIdiot(7,6),
                new NettoyeurNormal(0,0),
                new NettoyeurNormal(19,19)

        );

        Monde monde = new Monde(20, robots);
        System.out.println(monde);
        for (int i = 0; i < 4*400; i++){
            monde.nextRound();
            System.out.println("Tour " + 1);
            System.out.println(monde);
        }

    }
}
