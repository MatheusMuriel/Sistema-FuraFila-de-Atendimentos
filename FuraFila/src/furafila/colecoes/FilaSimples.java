package furafila.colecoes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class FilaSimples<E> implements Fila<E> {

    /**
     * Construtor padrão, em conformidade com a especificação de Collection.
     */
    public FilaSimples() {
        fila = new ArrayList<>();
    }
    /**
     * Construtor de cópia, em conformidade com a especificação de Collection.
     */
    public FilaSimples(Collection<E> toAdd) {
        this();
        addAll(toAdd);
    }

    @Override
    public E desenfileirar() { throw new RuntimeException("O aluno ainda não implementou este método."); }

    @Override
    public E proximo() {
        throw new RuntimeException("O aluno ainda não implementou este método.");
    }

    @Override
    public int size() {
        throw new RuntimeException("O aluno ainda não implementou este método.");
    }

    @Override
    public boolean isEmpty() {
        throw new RuntimeException("O aluno ainda não implementou este método.");
    }

    @Override
    public boolean contains(Object o) {
        throw new RuntimeException("O aluno ainda não implementou este método.");
    }

    @Override
    public Iterator<E> iterator() {
        throw new RuntimeException("O aluno ainda não implementou este método.");
    }

    @Override
    public Object[] toArray() {
        throw new RuntimeException("O aluno ainda não implementou este método.");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new RuntimeException("O aluno ainda não implementou este método.");
    }

    @Override
    public boolean add(E e) { throw new RuntimeException("O aluno ainda não implementou este método."); }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new RuntimeException("O aluno ainda não implementou este método.");
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new RuntimeException("O aluno ainda não implementou este método.");
    }

    @Override
    public void clear() {
        throw new RuntimeException("O aluno ainda não implementou este método.");
    }

    private ArrayList<E> fila;


    /***********************
     * Os métodos à seguir são opcionais, de acordo com a própria especificação de Collection.
     * Para o caso de Filas, não devem ser implementados. Por tanto, deixar como estão.
     *********/

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Esta operação não será implementada.");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Esta operação não será implementada.");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Esta operação não será implementada.");
    }
}
