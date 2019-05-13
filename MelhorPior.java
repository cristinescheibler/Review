
public class MelhorPior {

    protected int ano;
    protected String nome;

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        return "Ano = " + ano + ", Mediocres = " + nome + ".";
    }

}
