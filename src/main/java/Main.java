import java.awt.*;

public class Main {

    public static void main(String[] args) {

        Weapon w = new Weapon("KEWLSowrd",33,Weapon.EPIC);

        System.out.println(w.toString());

        Weapon z = new Weapon("hmmm",33,Weapon.RARE);
        System.out.println(z.toString());
    }
}
