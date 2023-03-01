package presentation;
import lombok.*;
import metier.CreditMetier;

@Data @AllArgsConstructor @NoArgsConstructor
public class CreditControleur implements ICreditControleur{

    CreditMetier creditMetier;
    @Override
    public void afficher_Mensualite(Long id) throws Exception {
        var creditAvecMensualite = creditMetier.calculer_Mensualite(id);
        System.out.println(creditAvecMensualite);
    }
}
