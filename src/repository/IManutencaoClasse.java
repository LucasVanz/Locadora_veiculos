package repository;

import entity.Veiculo;

import java.util.List;

public interface IManutencaoClasse<T> {
        void cadastrar(T objeto);
        void alterar(T objeto);
        T buscar(String objeto);
        List<T> listar();
}
