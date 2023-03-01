package metier;

public interface ICreditMetier<T,ID> {
    T calculer_Mensualite(ID id) throws Exception;
}
