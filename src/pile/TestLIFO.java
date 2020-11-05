package pile;

public class TestLIFO {

    public static void main(String[] args) {
        ListeLIFO<String> pile = new ListeLIFO();
        pile.push("String1");
        pile.push("String2");
        pile.push("String3");
        pile.push("String4");

        while (!pile.isEmpty()){
            System.out.println(pile.size());
            String o = pile.pop();
            System.out.println(o);
        }

    }
}
