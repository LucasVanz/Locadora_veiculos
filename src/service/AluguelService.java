package service;

import entity.Aluguel;
import entity.Veiculo;
import repository.AluguelRepository;

import java.time.temporal.ChronoUnit;

public class AluguelService {
    private AluguelRepository aluguelRepository;

    public AluguelService(AluguelRepository aluguelRepository){
        this.aluguelRepository = aluguelRepository;
    }

    public boolean addAluguel(Aluguel aluguel){
        if (aluguelRepository.buscar(aluguel.getVeiculo().getPlaca()) == null){
            aluguelRepository.cadastrar(aluguel);
            return true;
        }
        return false;
    }

    public Aluguel buscaAluguel(String placa){
        Aluguel aluguel = aluguelRepository.buscar(placa);
        if (aluguel != null){
            return aluguel;
        }
        return null;
    }

    public boolean devolucaoAluguel(String placa, Veiculo veiculo, int tipocCadastro){
        Aluguel aluguel = aluguelRepository.buscar(placa);
        calculaValores(aluguel, veiculo, tipocCadastro);
        if(aluguel != null){
            aluguelRepository.remover(aluguel);
            return true;
        }
        return false;
    }

    public void calculaValores(Aluguel aluguel, Veiculo veiculo, int tipoCadastro){
        long diasTotais = ChronoUnit.DAYS.between(aluguel.getDataHoraAluguel(), aluguel.getDataHoraDevolucao());
        double valorTotal = diasTotais * veiculo.getTamanho().getValorDiario();
        //CPF
        if (tipoCadastro == 1){
            if (diasTotais > 5){
                valorTotal = valorTotal - (valorTotal * 0.05);
            }//CNPJ
        } else if (tipoCadastro == 2) {
            if (diasTotais > 3) {
                valorTotal = valorTotal - (valorTotal * 0.10);
            }
        }
        aluguel.setValorDevolucao(valorTotal);
    }
}
