package entity;

public class ClientePessoaJuridica extends Cliente {
    public ClientePessoaJuridica(String nome, int idade, String cnpj) {
        super(nome, idade, cnpj);
    }

    @Override
    public String toString() {
        return "Nome = " + super.getNome() +
                ", idade = " + super.getIdade() +
                ", CNPJ = " + super.getCadastroPessoa();
    }

}