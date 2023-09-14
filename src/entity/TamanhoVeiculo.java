package entity;

public enum TamanhoVeiculo {
    PEQUENO(100.00),
    MEDIO(150.00),
    SUV(200.00);

    private double valorDiario;

    TamanhoVeiculo(double valorDiario) {
        this.valorDiario = valorDiario;
    }

    public double getValorDiario() {
        return this.valorDiario;
    }

}
