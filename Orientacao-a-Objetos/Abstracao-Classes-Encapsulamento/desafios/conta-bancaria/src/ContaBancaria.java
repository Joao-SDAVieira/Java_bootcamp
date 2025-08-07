public class ContaBancaria {
    private int chequeEspecial;
    private int saldo;
    private boolean usandoCheque = false;


    ContaBancaria(int valorPrimeiroDeposito){
        this.saldo = valorPrimeiroDeposito;
        if (valorPrimeiroDeposito <= 500){
            this.chequeEspecial = 50;
        } else {
            this.chequeEspecial = valorPrimeiroDeposito + valorPrimeiroDeposito / 2;
        }
    }


    public int getSaldo(){
        return this.saldo;
    }


    public int getChequeEspecial(){
        return this.chequeEspecial;
    }


    public String depositar(int valorDeposito){
        this.saldo += valorDeposito;
        return "Saldo Realizado com sucesso";
    }

    public boolean getUsandoCheque() {
        return this.usandoCheque;
    }

    public String sacar(int valorSaque){
        String message = "Saque realizado com sucesso!\n";
        if (valorSaque > this.saldo){
            System.out.println("Utilizando cheque especial\n");
            int divida = this.saldo - valorSaque;
            if ((chequeEspecial + divida) < 1){
                message = "Você não possui saldo e nem cheque especial o suficiente! Falha na operação\n";
                return message;
            }
            this.chequeEspecial += divida;
            this.saldo = divida/4;
            this.usandoCheque = true;
            return message;
        }
        this.saldo -= valorSaque;
        return message;
    }

    public String pagarBoleto(int valorBoleto){
        String message = "Boleto pago com sucesso!\n";
        if (valorBoleto > this.saldo){
            System.out.println("Utilizando cheque especial\n");
            int divida = this.saldo - valorBoleto;
            if ((chequeEspecial + divida) < 1){
                message = "Você não possui saldo e nem cheque especial o suficiente! Falha na operação\n";
                return message;
            }
            this.chequeEspecial += divida;
            this.saldo = divida/4;
            return message;
        }
        this.saldo -= valorBoleto;
        return message;
    }
}
