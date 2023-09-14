package entity;

public class ClientePessoaFisica extends Cliente {
    public ClientePessoaFisica(String nome, int idade, String cpf){
        super(nome, idade, cpf);
    }

    @Override
    public String toString() {
        return "Nome = " + super.getNome() +
                ", idade = " + super.getIdade() +
                ", CPF = " + super.getCadastroPessoa();
    }

}
