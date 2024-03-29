
import java.util.ArrayList;

public class Anos {

    protected ArrayList<Item> array;

    protected static class Item {

        protected String titulo;
        protected String classificacao;
        protected float score;
        protected int ano;
        protected String genero;
        
        public Item(String titulo, String classificacao, float score, int ano, String genero) {
            this.titulo = titulo;
            this.classificacao = classificacao;
            this.score = score;
            this.ano = ano;
            this.genero = genero;
        }

        public String toString() {
            return "[" + this.titulo + "]"
                    + "[" + this.classificacao + "]"
                    + "[" + this.score + "]"
                    + "[" + this.ano + "]"
                    + "[" + this.genero + "]";
        }
    }

    public Anos() {
        this.array = new ArrayList<Item>();
    }

    public void put(String titulo, String classificacao, float score, int ano, String genero) {
        this.array.add(new Item(titulo, classificacao, score, ano, genero));
    }

    @Override
    public String toString() {
        return this.array.toString();
    }

    

    

}
