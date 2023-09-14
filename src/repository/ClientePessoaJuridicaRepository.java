package repository;

import entity.ClientePessoaFisica;
import entity.ClientePessoaJuridica;

import java.util.ArrayList;
import java.util.List;

public class ClientePessoaJuridicaRepository implements IManutencaoClasse<ClientePessoaJuridica>{
    private List<ClientePessoaJuridica> clientePessoaJuridicaRepository;

    public ClientePessoaJuridicaRepository() {
        this.clientePessoaJuridicaRepository = new ArrayList<>();
    }
    @Override
    public void cadastrar(ClientePessoaJuridica cliente){
        this.clientePessoaJuridicaRepository.add(cliente);
    }

    @Override
    public ClientePessoaJuridica buscar(String cadastroPessoa){
        for (ClientePessoaJuridica cliente:clientePessoaJuridicaRepository) {
            if (cliente.getCadastroPessoa().equalsIgnoreCase(cadastroPessoa)){
                return cliente;
            }
        }
        return null;
    }

    @Override
    public void alterar(ClientePessoaJuridica cliente) {
        ClientePessoaJuridica clienteMod = buscar(cliente.getCadastroPessoa());
        clienteMod.setNome(cliente.getNome());
        clienteMod.setIdade(cliente.getIdade());
    }

    @Override
    public List<ClientePessoaJuridica> listar(){
        return new ArrayList<>(clientePessoaJuridicaRepository);
    }
}

