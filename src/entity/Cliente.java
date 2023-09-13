package entity;

public abstract class Pessoa {
    private String nome;
    private int idade;

    private String cadastroPessoa;
    private Veiculo veiculo;

    public Pessoa(String nome, int idade, String cadastroPessoa) {
        this.nome = nome;
        this.idade = idade;
        this.cadastroPessoa = cadastroPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCadastroPessoa() {
        return cadastroPessoa;
    }

    public void setCadastroPessoa(String cadastroPessoa) {
        this.cadastroPessoa = cadastroPessoa;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

}
