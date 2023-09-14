package repository;

import entity.Aluguel;

import java.util.ArrayList;
import java.util.List;

public class AluguelRepository{
    private List<Aluguel> aluguelRepository;

    public AluguelRepository() {
        this.aluguelRepository = new ArrayList<>();
    }

    public void cadastrar(Aluguel aluguel) {
        this.aluguelRepository.add(aluguel);

    }

    public void remover(Aluguel aluguel){
        this.aluguelRepository.remove(aluguel);
    }

    public Aluguel buscar(String placa) {
        for (Aluguel aluguel:aluguelRepository) {
            if (aluguel.getVeiculo().getPlaca().equalsIgnoreCase(placa)){
                return aluguel;
            }
        }
        return null;
    }


    public List<Aluguel> listar() {
        return new ArrayList<>(aluguelRepository);
    }
}
