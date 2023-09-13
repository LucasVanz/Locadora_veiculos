package entity;

public class ClienteClienteJuridica extends Cliente {
    public ClienteClienteJuridica(String nome, int idade, String cnpj) {
        super(nome, idade, cnpj);
    }

    @Override
    public String toString() {
        return "Nome = " + super.getNome() +
                ", idade = " + super.getIdade() +
                ", CNPJ = " + super.getCadastroPessoa();
    }

}