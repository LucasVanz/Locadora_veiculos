package entity;

public class Veiculo {
    private String modelo;
    private String placa;
    private int anoModelo;
    private String cor;
    private TamanhoVeiculo tamanho;
    private boolean alugado;


    public Veiculo(String modelo, String placa, int anoModelo, String cor) {
        this.modelo = modelo;
        this.placa = placa;
        this.anoModelo = anoModelo;
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public String getCor() {
        return cor;
    }

    public TamanhoVeiculo getTamanho() {
        return tamanho;
    }

    public boolean isAlugado() {
        return alugado;
    }




    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setTamanho(TamanhoVeiculo tamanho) {
        this.tamanho = tamanho;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }


    @Override
    public String toString() {
        return "Veiculo{" +
                "modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                ", anoModelo=" + anoModelo +
                ", cor='" + cor + '\'' +
                ", tamanho=" + tamanho +
                ", alugado=" + alugado +
                '}';
    }
}
