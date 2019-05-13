
public class DesvioPadrao {

    protected int ano;
    protected double count;

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public int getAno() {
        return ano;
    }

    public double getCount() {
        return count;
    }

    public String toString() {
        return "O Ano de " + ano + " possui uma desvio padrao aproximado de " + count + ".\n";
    }

}
