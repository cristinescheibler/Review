
public class SomaScore {

    protected int ano;
    protected int count;

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getAno() {
        return ano;
    }

    public int getCount() {
        return count;
    }

    public String toString() {
        return "O Ano de " + ano + " possui uma média aritmética aproximada de " + count + " Scores.\n";
    }

}
