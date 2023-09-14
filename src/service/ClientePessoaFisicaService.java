package service;

import entity.*;
import repository.ClientePessoaFisicaRepository;

import java.util.List;

public class ClientePessoaFisicaService {
    private ClientePessoaFisicaRepository clientePessoaFisicaRepository;

    public ClientePessoaFisicaService(ClientePessoaFisicaRepository clienteRepository) {
        this.clientePessoaFisicaRepository = clienteRepository;
    }

    public ClientePessoaFisica addCliente(ClientePessoaFisica cliente){
        if (clientePessoaFisicaRepository.buscar(cliente.getCadastroPessoa()) == null){
            clientePessoaFisicaRepository.cadastrar(cliente);
            return cliente;
        }
        return null;
    }

    public ClientePessoaFisica buscaCliente(String cadastroPessoa){
        return clientePessoaFisicaRepository.buscar(cadastroPessoa);
    }

    public void alteraCliente(ClientePessoaFisica cliente){
        //fazer depois
        clientePessoaFisicaRepository.alterar(cliente);
    }

    public List<ClientePessoaFisica> listarCliente(){
        return clientePessoaFisicaRepository.listar();
    }

    public boolean alugaVeiculoCpf(Veiculo veiculo, String cadastroAluguel) {
        ClientePessoaFisica clienteCpf = null;
        System.out.println("busca");
        clienteCpf = clientePessoaFisicaRepository.buscar(cadastroAluguel);
        if (clienteCpf == null){
            return false;
        }
        if (!veiculo.isAlugado()) {
            veiculo.setAlugado(true);
            return true;
        }
        return false;
    }
}

