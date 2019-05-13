
import java.util.ArrayList;

public class Avaliacao {

    public ArrayList preencherAnos(Anos y, ArrayList ano) {
        for (Anos.Item s : y.array) {
            if (!ano.contains(s.ano)) {
                ano.add(s.ano);
            }
        }
        return ano;
    }

    public ArrayList numReview(Anos a, ArrayList ano) {
        ArrayList<NumReview> sum = new ArrayList();
        int cont = 0;
        int i = 0;
        while (i != ano.size()) {
            cont = 0;
            NumReview n = new NumReview();
            n.setAno(Integer.valueOf(ano.get(i).toString()));
            for (Anos.Item s : a.array) {
                if (s.ano == (Integer.valueOf(ano.get(i).toString()))) {
                    cont++;
                }
                n.setCount(cont);
            }
            sum.add(n);
            i++;
        }
        for (i = 0; i < sum.size(); i++) {
            //System.out.println("" + sum.get(i).toString() + "");
        }
        return sum;
    }

    public ArrayList percMediocre(ArrayList sm, Anos a, ArrayList ano) {
        ArrayList<NumMediocre> med = new ArrayList();
        ArrayList<NumReview> sum = sm;
        int cont = 0;
        float media = 0;
        int i = 0;
        while (i != ano.size()) {
            cont = 0;
            NumMediocre n = new NumMediocre();
            n.setAno(Integer.valueOf(ano.get(i).toString()));
            for (Anos.Item s : a.array) {
                if (s.ano == (Integer.valueOf(ano.get(i).toString())) && s.classificacao.equals("Mediocre")) {

                    cont++;
                }
                media = (cont * 100) / sum.get(i).count;
                n.setCount(media);
            }
            med.add(n);
            i++;
        }

        return med;
    }

    public ArrayList media(Anos a, ArrayList sm, ArrayList ano) {
        ArrayList<SomaScore> soma = new ArrayList();
        ArrayList<NumReview> sum = sm;
        int count = 0;
        int i = 0;
        float media = 0;
        while (i != ano.size()) {
            count = 0;
            SomaScore n = new SomaScore();
            n.setAno(Integer.valueOf(ano.get(i).toString()));
            for (Anos.Item s : a.array) {
                if (s.ano == (Integer.valueOf(ano.get(i).toString()))) {
                    media += a.array.get(i).score;
                    count++;
                }
            }
            media = media / count;
            n.setCount((int) media);
            soma.add(n);
            i++;
        }
        for (i = 0; i < soma.size(); i++) {
            //System.out.println("o Ano de " + soma.get(i).ano + " possui uma média aritmetica aproximada de " + soma.get(i).count + " Scores.");
        }
        return soma;
    }

    public ArrayList desvioPadrao(Anos a, ArrayList sm, ArrayList ano) {
        ArrayList<DesvioPadrao> soma = new ArrayList();
        ArrayList<SomaScore> sum = sm;
        int i = 0;
        double media = 0;
        int count = 0;
        while (i != ano.size()) {
            count = 0;
            DesvioPadrao n = new DesvioPadrao();
            n.setAno(Integer.valueOf(ano.get(i).toString()));
            for (Anos.Item s : a.array) {
                if (s.ano == (Integer.valueOf(ano.get(i).toString()))) {
                    media += Math.pow(a.array.get(i).score - sum.get(i).count, 2);
                    count++;
                }
            }
            media = Math.sqrt(media / count);
            n.setCount(media);
            soma.add(n);
            i++;
        }
        return soma;
    }

    public void melhorJogo(Anos a, ArrayList ano) {
        ArrayList<MelhorPior> melhor = new ArrayList();
        int i = 0;
        float score = 0;
        while (i != ano.size()) {
            score = 0;
            MelhorPior n = new MelhorPior();
            n.setAno(Integer.valueOf(ano.get(i).toString()));
            for (Anos.Item s : a.array) {
                if (s.ano == (Integer.valueOf(ano.get(i).toString())) && s.score > score) {
                    score = s.score;
                    n.setNome(s.titulo);
                }
            }
            melhor.add(n);
            i++;
        }
        for (i = 0; i < melhor.size(); i++) {
            System.out.println("O jogo do ano de " + melhor.get(i).ano + " com maior Score é " + melhor.get(i).nome + ".");
        }
    }

    public void piorJogo(Anos a, ArrayList ano) {
        ArrayList<MelhorPior> melhor = new ArrayList();
        int i = 0;
        float score = 0;
        while (i != ano.size()) {
            score = a.array.get(0).score;
            MelhorPior n = new MelhorPior();
            n.setAno(Integer.valueOf(ano.get(i).toString()));
            for (Anos.Item s : a.array) {
                if (s.ano == (Integer.valueOf(ano.get(i).toString())) && s.score < score) {
                    score = s.score;
                    n.setNome(s.titulo);
                }
            }
            melhor.add(n);
            i++;
        }
        for (i = 0; i < melhor.size(); i++) {
            System.out.println("O jogo do ano de " + melhor.get(i).ano + " com menor Score é " + melhor.get(i).nome + ".");
        }
    }

    public void jogosAction(Anos a, ArrayList ano) {
        ArrayList <SomaScore> action = new ArrayList();
        int cont = 0;
        int [] maislancado ={ 0 , 0 };
        int i = 0;
        while (i != ano.size()) {
            cont = 0;
            SomaScore n = new SomaScore();
            n.setAno(Integer.valueOf(ano.get(i).toString()));
            for (Anos.Item s : a.array) {
                String [] genero  = s.genero.split("/");
                if (s.ano == (Integer.valueOf(ano.get(i).toString())) && (genero[0].equals("Action"))) {
                    cont++;
                }
                n.setCount(cont);
            }
            action.add(n);
            i++;
        }
        for (i = 0; i < action.size(); i++) {
            if(action.get(i).count > maislancado[1]){
                maislancado[1] = action.get(i).count;
                maislancado[0] =  action.get(i).ano;
            }
        }
        System.out.println("O Ano com mais lançamentos de Jogos do tipo 'Action' foi " +  maislancado[0] 
                + " com o total de "+maislancado[1] + " Jogos Lançados."
        );
    }
}
