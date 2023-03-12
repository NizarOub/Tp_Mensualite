package dao;

public interface IDao<T,ID> {
    T trouverParID(ID NO_id);
}
