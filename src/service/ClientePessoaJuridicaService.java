package service;

import entity.Aluguel;
import entity.ClientePessoaFisica;
import entity.ClientePessoaJuridica;
import entity.Veiculo;
import repository.ClientePessoaFisicaRepository;
import repository.ClientePessoaJuridicaRepository;

import java.util.List;

public class ClientePessoaJuridicaService {
    private ClientePessoaJuridicaRepository clientePessoaJuridicaRepository;

    public ClientePessoaJuridicaService(ClientePessoaJuridicaRepository clienteRepository) {
        this.clientePessoaJuridicaRepository = clienteRepository;
    }

    public ClientePessoaJuridica addCliente(ClientePessoaJuridica cliente){
        if (clientePessoaJuridicaRepository.buscar(cliente.getCadastroPessoa()) == null){
            clientePessoaJuridicaRepository.cadastrar(cliente);
            return cliente;
        }
        return null;
    }

    public ClientePessoaJuridica buscaCliente(String cadastroPessoa){
        return clientePessoaJuridicaRepository.buscar(cadastroPessoa);
    }

    public void alteraCliente(ClientePessoaJuridica cliente){
        clientePessoaJuridicaRepository.alterar(cliente);
    }

    public List<ClientePessoaJuridica> listarCliente(){
        return clientePessoaJuridicaRepository.listar();
    }
    public boolean alugaVeiculoCnpj(Veiculo veiculo, String cadastroAluguel) {
        ClientePessoaJuridica clienteCnpj;
        clienteCnpj = clientePessoaJuridicaRepository.buscar(cadastroAluguel);
        if (clienteCnpj == null){
            return false;
        }
        if (!veiculo.isAlugado()) {
            veiculo.setAlugado(true);
            return true;
        }
        return false;
    }
}
