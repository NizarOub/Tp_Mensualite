package model;


import lombok.*;
@Data @AllArgsConstructor @NoArgsConstructor
public class Credit {


    private Long NO_id;
    private Double NO_capitale_Emprunt;
    private Integer NO_nombre_Mois;
    private Double NO_taux_Mensuel;
    private String NO_nom_Demandeur;
    private Double NO_mensualite;

    @Override
    public String toString(){
        var creditStr = "==================================================================== \n";
            creditStr+= "=> Crédit n°                  : " +getNO_id()+ "                        \n";
            creditStr+= "=> Nom du demandeur de crédit : " + getNO_nom_Demandeur() + "           \n";
            creditStr+= "-------------------------------------------------------------------- \n";
            creditStr+= "=> Capitale Emprunté          : " + getNO_capitale_Emprunt() + "        \n";
            creditStr+= "=> Nombre de mois             : " + getNO_nombre_Mois() + "             \n";
            creditStr+= "=> Taux mensuel               : " + getNO_taux_Mensuel() + "            \n" ;
            creditStr+= "-------------------------------------------------------------------- \n";
            creditStr+= "=> Mensualité                 : "
                    + (getNO_mensualite() == 0.0 ? "NON-CALCULE":getNO_mensualite()+ " DH/mois")+"\n";
            creditStr+= "==================================================================== \n";

        return creditStr;
    }
}
