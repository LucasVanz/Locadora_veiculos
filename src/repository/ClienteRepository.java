package repository;

import entity.ClienteClienteJuridica;
import entity.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClientePessoaFisicaRepository {
    private List<Cliente> clienteRepository;

    public ClientePessoaFisicaRepository() {
        this.clienteRepository = new ArrayList<>();
    }

    public void cadastrarClienteCpf(Cliente clienteClienteFisica){
        this.clienteRepository.add(clienteClienteFisica);
    }
    public void cadastrarClienteCnpj(ClienteClienteJuridica clientePessoaJuridica) {
        this.clientePessoaJuridicaRepository.add(clientePessoaJuridica);
    }
    public void alterarClienteCpf() {
        //fazer depois
    }
    public void alterarClienteCnpj() {
        //fazer depois
    }
    public ClienteClienteJuridica buscaCnpj(String cnpj){
        for (C:) {

        }
    }
}
