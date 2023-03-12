package metier;

import dao.IDao;

import lombok.*;
import model.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Data @AllArgsConstructor @NoArgsConstructor
@Service("metier")
public class CreditMetier implements ICreditMetier{
    @Autowired
    @Qualifier("dao")
    IDao<Credit,Long> creditDao;
    @Override
    public Credit calculer_Mensualite(Long NO_id) throws Exception{
        var credit = creditDao.trouverParID(NO_id);

        if (credit == null)
        {
            throw new Exception("L'id du credit est incorrecte :: [Credit non trouve]");
        }
        else {
            double  taux         = credit.getNO_taux_Mensuel();
                    taux         = taux/1200;
            double  capitale     = credit.getNO_capitale_Emprunt();
            int     nbr_mois     = credit.getNO_nombre_Mois();

            double  mensualite   = (capitale * taux) / (1 - (Math.pow((1 + taux), -1 * nbr_mois)));
                    mensualite   = Math.round(mensualite*100)/100;

                   credit.setNO_mensualite(mensualite);

            return credit;
        }
    }
}
