package furafila.colecoes;

import java.util.Collection;

public interface Fila<E> extends Collection<E> {
    /**
     * Enfileira o elemento, de acordo com a lógica específica da implementação. Trata-se
     * da mesma operação feita pelo método add de Collection, apenas com nome mais adequado
     * à semântica dessa classe específica de coleções.
     *
     * @param objeto Referência do objeto a ser enfileirado.
     */
    default void enfileirar(E objeto) {
        this.add(objeto);
    }

    /**
     * Remove o primeiro elemento da fila e retorna-o.
     *
     * @return Referência para o primeiro elemento da fila, removido da mesma.
     */
    E desenfileirar();

    /**
     * Retorna o primeiro elemento da fila, sem removê-lo.
     *
     * @return Referência para o primeiro elemento da fila.
     */
    E proximo();
}
