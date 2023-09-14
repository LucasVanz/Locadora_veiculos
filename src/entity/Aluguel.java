package entity;

import java.time.LocalDateTime;

public class Aluguel{
    private String cadastroAluguel;
    private Veiculo veiculo;
    private LocalDateTime dataHoraAluguel;
    private LocalDateTime dataHoraDevolucao;
    private String local;

    private double valorDevolucao;
    public Aluguel(String cadastroAluguel, Veiculo veiculo, LocalDateTime dataHoraAluguel, LocalDateTime dataHoraDevolucao, String local) {
        this.cadastroAluguel = cadastroAluguel;
        this.veiculo = veiculo;
        this.dataHoraAluguel = dataHoraAluguel;
        this.dataHoraDevolucao = dataHoraDevolucao;
        this.local = local;
    }

    public String getCadastroAluguel() {
        return cadastroAluguel;
    }

    public void setCadastroAluguel(String cadastroAluguel) {
        this.cadastroAluguel = cadastroAluguel;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDateTime getDataHoraAluguel() {
        return dataHoraAluguel;
    }

    public void setDataHoraAluguel(LocalDateTime dataHoraAluguel) {
        this.dataHoraAluguel = dataHoraAluguel;
    }

    public LocalDateTime getDataHoraDevolucao() {
        return dataHoraDevolucao;
    }

    public void setDataHoraDevolucao(LocalDateTime dataHoraDevolucao) {
        this.dataHoraDevolucao = dataHoraDevolucao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public double getValorDevolucao() {
        return valorDevolucao;
    }

    public void setValorDevolucao(double valorDevolucao) {
        this.valorDevolucao = valorDevolucao;
    }

    @Override
    public String toString() {
        return "Aluguel{" +
                "cadastroAluguel='" + cadastroAluguel + '\'' +
                ", veiculo=" + veiculo +
                ", dataHoraAluguel=" + dataHoraAluguel +
                ", dataHoraDevolucao=" + dataHoraDevolucao +
                ", local='" + local + '\'' +
                ", valorDevolucao=" + valorDevolucao +
                '}';
    }
}
