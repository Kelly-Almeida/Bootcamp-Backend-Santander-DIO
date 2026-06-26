public class Carro {
    private boolean ligado;
    private float velocidade;
    private int marcha;

    public Carro() {
        this.ligado = false;
        this.velocidade = 0;
        this.marcha = 0;
    }

    public boolean getLigado() { return this.ligado; }
    public float getVelocidade() { return this.velocidade; }
    public int getMarcha() { return this.marcha; }

    public void setMarcha(int marcha) {
        if (!this.ligado) {
            System.out.println("Não é possível mudar de marcha com o carro desligado!");
            return;
        }
        if (marcha >= 0 && marcha <= 6) {
            this.marcha = marcha;
            System.out.println("Marcha alterada para: " + marcha);
        } else {
            System.out.println("Marcha inválida! Escolha entre 0 e 6.");
        }
    }

    public void ligar() {
        if (this.ligado) {
            System.out.println("O carro já está ligado!");
        } else {
            this.ligado = true;
            System.out.println("Carro ligado!!");
        }
    }

    public void desligar() {
        if (this.marcha == 0 && this.velocidade == 0) {
            if (this.ligado) {
                this.ligado = false;
                System.out.println("Carro desligado!!");
            } else {
                System.out.println("O carro já está desligado!!");
            }
        } else {
            System.out.println("Desacelere e deixe o carro em ponto morto (marcha 0) para desligar!!");
        }
    }

    public void acelerar() {
        if (!this.ligado) {
            System.out.println("O carro está desligado!!");
            return;
        }

        if (this.marcha == 0) {
            System.out.println("Carro está na marcha 0 (ponto morto). Mude de marcha para acelerar!");
            return;
        }

        if (this.velocidade >= 120) {
            System.out.println("Você está na velocidade máxima (120 Km/h)!");
            return;
        }

        boolean velocidadeIncorreta = false;

        switch (this.marcha) {
            case 1:
                if (this.velocidade >= 0 && this.velocidade < 20) this.velocidade++;
                else velocidadeIncorreta = true;
                break;
            case 2:
                if (this.velocidade >= 20 && this.velocidade < 40) this.velocidade++;
                else velocidadeIncorreta = true;
                break;
            case 3:
                if (this.velocidade >= 40 && this.velocidade < 60) this.velocidade++;
                else velocidadeIncorreta = true;
                break;
            case 4:
                if (this.velocidade >= 60 && this.velocidade < 80) this.velocidade++;
                else velocidadeIncorreta = true;
                break;
            case 5:
                if (this.velocidade >= 80 && this.velocidade < 100) this.velocidade++;
                else velocidadeIncorreta = true;
                break;
            case 6:
                if (this.velocidade >= 100 && this.velocidade < 120) this.velocidade++;
                else velocidadeIncorreta = true;
                break;
        }

        if (velocidadeIncorreta) {
            System.out.println("Velocidade incompatível com a marcha atual! Mude de marcha.");
        } else {
            System.out.println("Carro acelerado! Velocidade atual: " + this.velocidade + " Km/h");
        }
    }

    public void desacelerar() {
        if (!this.ligado) {
            System.out.println("O carro está desligado!!");
            return;
        }

        if (this.velocidade <= 0) {
            System.out.println("O carro já está parado!");
            return;
        }

        this.velocidade -= 5;
        if (this.velocidade < 0) this.velocidade = 0;
        System.out.println("Carro desacelerado! Velocidade atual: " + this.velocidade + " Km/h");
    }

    public boolean virar() {
        return this.velocidade > 0 && this.velocidade <= 40;
    }
}