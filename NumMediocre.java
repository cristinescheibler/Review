
public class NumMediocre {

    protected int ano;
    protected float count;

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setCount(float count) {
        this.count = count;
    }

    public int getAno() {
        return ano;
    }

    public float getCount() {
        return count;
    }

    public String toString() {
        return "O ano de " + ano + " possui um percentual de Mediocres de " + count + "%.\n";
    }

}
