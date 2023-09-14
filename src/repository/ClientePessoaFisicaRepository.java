package repository;

import entity.Cliente;
import entity.ClientePessoaFisica;

import java.util.ArrayList;
import java.util.List;

public class ClientePessoaFisicaRepository implements IManutencaoClasse<ClientePessoaFisica>{
    private List<ClientePessoaFisica> clientePessoaFisicaRepository;

    public ClientePessoaFisicaRepository() {
        this.clientePessoaFisicaRepository = new ArrayList<>();
    }
    @Override
    public void cadastrar(ClientePessoaFisica cliente){
        this.clientePessoaFisicaRepository.add(cliente);
    }

    @Override
    public ClientePessoaFisica buscar(String cadastroPessoa){
        for (ClientePessoaFisica cliente:clientePessoaFisicaRepository) {
            if (cliente.getCadastroPessoa().equalsIgnoreCase(cadastroPessoa)){
                return cliente;
            }
        }
        return null;
    }

    @Override
    public void alterar(ClientePessoaFisica cliente) {
        ClientePessoaFisica clienteMod = buscar(cliente.getCadastroPessoa());
        clienteMod.setNome(cliente.getNome());
        clienteMod.setIdade(cliente.getIdade());
    }

    @Override
    public List<ClientePessoaFisica> listar(){
        return new ArrayList<>(clientePessoaFisicaRepository);
    }
}

