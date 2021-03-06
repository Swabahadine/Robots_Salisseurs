package monde;

import robot.Robot;
import robot.nettoyeur.NettoyeurManiaque;
import robot.pollueur.PollueurIdiot;

import java.util.Arrays;
import java.util.List;

public class TestMonde {
    public static void main(String[] args) {
        final int TOURS = 200;
        List<Robot> robots = Arrays.asList(
                new PollueurIdiot(4,6),
                new PollueurIdiot(7,6),
                new PollueurIdiot(7,6),
                new PollueurIdiot(7,6),
                new PollueurIdiot(7,6),
                new NettoyeurManiaque(0,0)

        );
        Monde monde = new Monde(20, robots);
        System.out.println("********Affichage du monde**********");
        System.out.println(monde);
        System.out.println("************************************\n");
        for (int i = 1; i <= TOURS; i++){
            System.out.println("Tour " + i);
            monde.nextRound();
            System.out.println(monde);
        }

    }
}
