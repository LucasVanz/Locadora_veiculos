package repository;

import entity.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoRepository implements IManutencaoVeiculo{
    private List<Veiculo> veiculoRepository;

    public VeiculoRepository(List<Veiculo> veiculoRepository) {
        this.veiculoRepository = new ArrayList<>();
    }

    public void cadastrarVeiculo(Veiculo veiculo){
        this.veiculoRepository.add(veiculo);
    }

    public List<Veiculo> listaVeiculo(){
        return new ArrayList<>(veiculoRepository);
    }

    public Veiculo buscarVeiculo(String placa){
        for (Veiculo veiculo:veiculoRepository) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)){
                return veiculo;
            }
        }
        return null;
    }
    public void alterarVeiculo(Veiculo veiculo){
        //fazer depois
    }
    public boolean alugarVeiculo(String placa, String cpf){
        //buscar o veiculo
        //buscar o cliente CPF

    }
    public void devolverVeiculoCnpj(){

    }
}
