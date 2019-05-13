
import java.io.*;
import java.util.ArrayList;

public class Review {

    public static void main(String[] args) throws Exception {
        Avaliacao a = new Avaliacao();
        String arquivo = "game-reviews.csv";
        BufferedReader leitor = null;
        String texto = "";
        int cont = 0;
        Anos year = new Anos();
        try {
            leitor = new BufferedReader(new FileReader(arquivo));
            while ((texto = leitor.readLine()) != null) {
                String[] dados = texto.split(";");
                if (!dados[0].equals("title")) {
                    year.put(dados[0], dados[2], Float.valueOf(dados[3]), Integer.valueOf(dados[6]),dados[4]);
                    cont++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado" + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBounds" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException" + e.getMessage());
        } finally {
            if (leitor != null) {
                try {
                    leitor.close();
                } catch (IOException e) {
                    System.out.println("IOException" + e.getMessage());
                }

            }
        }
        ArrayList<Integer> ano = new ArrayList();
        ArrayList<NumReview> sum = new ArrayList();
        ArrayList<SomaScore> soma = new ArrayList();
        sum = a.preencherAnos(year, ano);
        do {
            cont = menu();
            sum = a.preencherAnos(year, ano);
            switch (cont) {
                case 1:
                    System.out.println(a.numReview(year, ano));
                    break;                    
                case 2:
                    soma = a.numReview(year, ano);
                    System.out.println(a.percMediocre(soma, year, ano));
                    break;
                case 3:
                    System.out.println(a.media(year, sum, ano));
                    break;
                case 4:
                    soma = a.media(year, sum, ano);
                    System.out.println(a.desvioPadrao(year, soma, ano));
                    break;
                case 5:
                    a.melhorJogo(year, ano);
                    break;
                case 6:
                    a.piorJogo(year, ano);
                    break; 
                case 7:
                    a.jogosAction(year, ano);
                    break;
            }
        } while (cont != 8);
    }
    public static int menu() {
        int c = Entrada.leiaInt("Digite para analisar:\n"
                + "[1] Número de Reviews de cada ano.\n"
                + "[2] Percentual de ‘Mediocre’ Reviews referente ao ano de lançamento.\n"
                + "[3] A média aritmética dos Scores.\n"
                + "[4] O desvio padrão populacional dos Scores.\n"
                + "[5] O Melhor Jogo de cada ano.\n"
                + "[6] O Pior Jogo de cada ano.\n"
                + "[7] O Ano em que foi lançado um maior número de jogos do gênero ‘Action’.\n"
                + "[8] Sair.\n");
        return c;
    }
}
