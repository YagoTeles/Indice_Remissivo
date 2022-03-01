import java.io.*;
import java.util.Scanner;
//------------------------------------------------------------------------------------------
    //Projeto IndiceRemissivo
    //Estrutura de Dados M24AB
    //Universidade de Fortaleza
    //Yago Silva Teles Costa - 1810447
//------------------------------------------------------------------------------------------
public class IndiceRemissivo {
    public static void main(String[] args) throws IOException {

       //Leitura dos arquivos txt------------------------------------------------------------
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Digite o localizaçao do arquivo contendo o texto:");
        String textoLoca = sc.nextLine();

        String saida = Processamento.pickCaminhoArquivo(textoLoca);

        System.out.println("Digite o localizaçao do arquivo contando as palavras:");
        String palavrasLoca = sc.nextLine();
        System.out.println();

        File texto = new File(textoLoca);
        File palavras = new File(palavrasLoca);

        BufferedReader tr = new BufferedReader(new FileReader(texto));
        BufferedReader pr = new BufferedReader(new FileReader(palavras));
       //Declaracoes---------------------------------------------------------------------------
        String string;
        int contLinhas = 1;
        HashMap map = new HashMap();
        ArvoreBinariaBusca arv = new ArvoreBinariaBusca(saida + "saida.txt");
       //Inserção dos dados na tabela hashing---------------------------------------------------
        while ((string = tr.readLine()) != null) {

            string = string.replaceAll("[,!.?*()]","");
            String[] entrada = string.split(" ");

                for (String s : entrada) {
                    map.put(s.toLowerCase(), contLinhas);
                }
        contLinhas++;

        }
       //Adicionar os dados da tabela hashing na arvore de busca--------------------------------
        arv.abc(map);
        while ((string = pr.readLine()) != null) {

            string = string.replaceAll("[,!.?*()]","");
            String[] entrada = string.split(" ");

                for (String s : entrada) {
                    arv.adicionar(s.toLowerCase());
                }
        }
       //Exibicao dos resultados-----------------------------------------------------------------
        arv.exibirEmOrdem();
        arv.arq.close();
        System.out.println("\u001B[92mArquivo txt gerado na localização: " + saida + "saida.txt" );
       //-----------------------------------------------------------------------------------------
    }

}
