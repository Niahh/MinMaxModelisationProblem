import plateau.Case;
import plateau.Plateau;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Plateau plateau = new Plateau();
        Case case1 = new Case(1, 2, true," ");
        case1.displayCase();
    }
}
