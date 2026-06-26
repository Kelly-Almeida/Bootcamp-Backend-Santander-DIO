class ContaBancaria {
    private final String titular;
    private final String cpf;
    private float saldo;
    private final float chequeEspecialMaximo;
    private float chequeGasto = 0.00F;

    public ContaBancaria(String titular, String cpf, float saldo) {
        this.titular = titular;
        this.cpf = cpf;
        this.saldo = saldo;

        if (saldo <= 500) {
            this.chequeEspecialMaximo = 50;
        } else {
            this.chequeEspecialMaximo = saldo / 2;
        }

        System.out.println("Conta criada com sucesso!!");
    }

    public String getTitular() { return this.titular; }
    public String getCpf() { return this.cpf; }
    public float getSaldo() { return this.saldo; }
    public float getChequeEspecial() { return this.chequeEspecialMaximo - this.chequeGasto; }

    public boolean depositar(float valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para depósito!!");
            return false;
        }


        if (chequeGasto > 0) {
            if (valor >= chequeGasto) {
                valor -= chequeGasto;
                chequeGasto = 0;
                this.saldo += valor;
            } else {
                chequeGasto -= valor;
                valor = 0;
            }
        } else {
            this.saldo += valor;
        }

        System.out.println("Depósito realizado com sucesso!!");
        return true;
    }

    public boolean sacar(float valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para saque!!");
            return false;
        }


        if (valor <= this.saldo + getChequeEspecial()) {
            if (valor <= this.saldo) {
                this.saldo -= valor;
            } else {
                float restante = valor - this.saldo;
                this.saldo = 0;
                this.chequeGasto += restante * 1.20F;
                System.out.println("Cheque especial usado!");
            }
            System.out.println("Saque bem sucedido!!");
            return true;
        } else {
            System.out.println("Saldo e cheque especial insuficientes.");
            return false;
        }
    }

    public boolean pagarBoleto(float boleto) {
        if (boleto <= 0) {
            System.out.println("Valor inválido para boleto!!");
            return false;
        }

        if (boleto <= this.saldo + getChequeEspecial()) {
            if (boleto <= this.saldo) {
                this.saldo -= boleto;
            } else {
                float restante = boleto - this.saldo;
                this.saldo = 0;
                this.chequeGasto += restante * 1.20F;
                System.out.println("Cheque especial usado para pagar o boleto!");
            }
            System.out.println("Pagamento bem sucedido!!");
            return true;
        } else {
            System.out.println("Saldo insuficiente para pagar este boleto.");
            return false;
        }
    }
}