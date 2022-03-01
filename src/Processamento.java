public class Processamento {
    public static String pickCaminhoArquivo(String arquivo){
        int posicao = 0;
        for(int i = arquivo.length() - 1; i >= 0; i-- ){
            if(arquivo.charAt(i) == '\\' || arquivo.charAt(i) == '/' ) {
                posicao = i + 1;
                break;
            }
        }
        return arquivo.substring(0,posicao);
    }
}
