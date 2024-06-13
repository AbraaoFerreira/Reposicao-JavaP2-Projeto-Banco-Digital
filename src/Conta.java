interface Conta {
    double consultarSaldo();
    void depositar(double valor);
    boolean sacar(double valor);
}