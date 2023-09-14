package repository;

import entity.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VeiculoRepository implements IManutencaoClasse<Veiculo> {
    private List<Veiculo> veiculoRepository;

    public VeiculoRepository() {
        this.veiculoRepository = new ArrayList<>();
    }
    @Override
    public void cadastrar(Veiculo veiculo){
        this.veiculoRepository.add(veiculo);
    }

    @Override
    public Veiculo buscar(String placa){
        for (Veiculo veiculo:veiculoRepository) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)){
                return veiculo;
            }
        }
        return null;
    }
    @Override
    public void alterar(Veiculo veiculo){
        Veiculo veiculoMod = buscar(veiculo.getPlaca());
        veiculoMod.setAnoModelo(veiculo.getAnoModelo());
        veiculoMod.setCor(veiculo.getCor());
    }

    @Override
    public List<Veiculo> listar(){
        return new ArrayList<>(veiculoRepository);
    }


}
