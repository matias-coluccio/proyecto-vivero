public interface Crud<T> {
    void agregar(T dato);
    void eliminar(T dato);
    void modificar(T dato);
    String  listar();

}
