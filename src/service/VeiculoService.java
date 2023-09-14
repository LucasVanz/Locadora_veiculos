package service;

import entity.Aluguel;
import entity.ClientePessoaFisica;
import entity.Veiculo;
import repository.VeiculoRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class VeiculoService {
    private VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public Veiculo addVeiculo(Veiculo veiculo){
        if (veiculoRepository.buscar(veiculo.getPlaca()) == null){
            veiculoRepository.cadastrar(veiculo);
            return veiculo;
        }
        return null;
    }

    public Veiculo buscaVeiculo(String placa){
        return veiculoRepository.buscar(placa);
    }

    public void alteraVeiculo(Veiculo veiculo){
        veiculoRepository.alterar(veiculo);
    }

    public List<Veiculo> listarVeiculo(){
        return veiculoRepository.listar();
    }


}
