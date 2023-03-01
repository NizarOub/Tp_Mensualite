package model;


import lombok.*;
@Data @AllArgsConstructor @NoArgsConstructor
public class Credit {


    private Long id;
    private Double capitale_Emprunt;
    private Integer nombre_Mois;
    private Double taux_Mensuel;
    private String nom_Demandeur;
    private Double mensualite;

}
