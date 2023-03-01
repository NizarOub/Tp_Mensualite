import dao.daoVolatile.CreditDao;
import lombok.var;
import metier.CreditMetier;
import presentation.CreditControleur;

import java.util.Scanner;

public class SimulateurDeCredit_App {
    static Scanner clavier = new Scanner(System.in);

    private static boolean estUnNombre(String input){
        try {
            Integer.parseInt(input);
            return true;
        }
        catch (Exception e ){
            return false;
        }
    }

    public static void test1(){
        // instanciation des différents compsants de l'application
        var dao = new CreditDao();
        var metier = new CreditMetier();
        var controleur = new CreditControleur();
        // injection des dépendances
        metier.setCreditDao(dao);
        controleur.setCreditMetier(metier);
        // tester
        String rep = "";
        do {
            System.out.println("=> [Test 1] calcule de Mensualité de cédit <= \n");
            try {
                String input = "";
                while (true){
                    System.out.println("=> Entrez l'id du crédit : ");
                    input = clavier.nextLine();
                    if (estUnNombre(input)) break;
                    System.err.println("Entrée non valide !!!");
                }
                long id = Long.parseLong(input);
                controleur.afficher_Mensualite(id);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            System.out.println("Voulez vous quittez (oui/non) ? ");
            rep = clavier.nextLine();
        }while (!rep.equalsIgnoreCase("oui"));
        System.out.println("Au revoir ^_^");
    }
    public static void main(String[] args) {
        test1();
    }
}