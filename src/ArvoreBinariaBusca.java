import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArvoreBinariaBusca {
    private No raiz;
    String local;
    HashMap a = new HashMap();
    ArrayList<Integer> tabela = new ArrayList();
    FileWriter arq;
    PrintWriter imprimir;
    public ArvoreBinariaBusca(String local) throws IOException {
        this.arq = new FileWriter(local);
        this.imprimir = new PrintWriter(arq);
        raiz = null;
    }
    public void adicionar(String valor) {
        if (raiz == null) {
            raiz = new No(valor);
        }
        else {
            adicionar(valor, raiz);
        }
    }

    private void adicionar(String valor, No raiz) {
        if (valor.compareToIgnoreCase(raiz.valor) < 0 ) {
            if (raiz.esquerda == null) {
                raiz.esquerda = new No(valor);
            }
            else {
                adicionar(valor, raiz.esquerda);
            }
        }
        else if (valor.compareToIgnoreCase(raiz.valor) > 0 ) {
            if (raiz.direita == null) {
                raiz.direita = new No(valor);
            }
            else {
                adicionar(valor, raiz.direita);
            }
        }
    }

    public boolean pesquisar(String valor) {
        if (raiz == null) {
            return false;
        }
        else {
            return pesquisar(valor, raiz);
        }
    }

    private boolean pesquisar(String valor, No raiz) {
        if (valor.compareToIgnoreCase(raiz.valor) == 0) {
            return true;
        }
        else if (valor.compareToIgnoreCase(raiz.valor) < 0 ) {
            if (raiz.esquerda == null) {
                return false;
            }
            else {
                return pesquisar(valor, raiz.esquerda);
            }
        }
        else if (valor.compareToIgnoreCase(raiz.valor) > 0 ) {
            if (raiz.direita == null) {
                return false;
            }
            else {
                return pesquisar(valor, raiz.direita);
            }
        }

        return false;
    }

    public void remover(String valor) {
        if (raiz != null) {
            remover(valor, raiz, null);
        }
    }

    private void remover(String valor, No raiz, No pai) {
        if (valor.compareToIgnoreCase(raiz.valor) == 0 ) {
            if (raiz.esquerda == null && raiz.direita == null) {
                if (raiz == pai.esquerda)
                    pai.esquerda = null;
                else
                    pai.direita = null;
            }
            else if (raiz.esquerda != null && raiz.direita == null) {
                if (raiz == pai.esquerda)
                    pai.esquerda = raiz.esquerda;
                else
                    pai.direita = raiz.esquerda;
            }
            else if (raiz.esquerda == null && raiz.direita != null) {
                if (raiz == pai.esquerda)
                    pai.esquerda = raiz.direita;
                else
                    pai.direita = raiz.direita;
            }
            else if (raiz.esquerda != null && raiz.direita != null) {
                raiz.valor = menorValor(raiz.direita);
                remover(raiz.valor, raiz.direita, raiz);
            }
        }
        else if (valor.compareToIgnoreCase(raiz.valor) < 0 ) {
            if (raiz.esquerda != null)
                remover(valor, raiz.esquerda, raiz);
        }
        else if (valor.compareToIgnoreCase(raiz.valor) > 0 ) {
            if (raiz.direita != null)
                remover(valor, raiz.direita, raiz);
        }
    }

    private String menorValor(No raiz) {
        if (raiz.esquerda == null)
            return raiz.valor;
        else
            return menorValor(raiz.esquerda);
    }

    public void exibirPreOrdem() {
        if (raiz != null) {
            exibirPreOrdem(raiz);
            System.out.println();
        }
    }

    private void exibirPreOrdem(No raiz) {
        System.out.print(raiz.valor + " ");

        if (raiz.esquerda != null) {
            exibirPreOrdem(raiz.esquerda);
        }

        if (raiz.direita != null) {
            exibirPreOrdem(raiz.direita);
        }
    }

    public void exibirEmOrdem() throws IOException {
        if (raiz != null) {
            exibirEmOrdem(raiz);
            System.out.println();
        }
    }

    private void exibirEmOrdem(No raiz) throws IOException {
        if (raiz.esquerda != null) {
            exibirEmOrdem(raiz.esquerda);
        }

        System.out.print(raiz.valor);
        imprimir.printf(raiz.valor);
        tabela = a.get(raiz.valor);

        int tmp = 25 - raiz.valor.length();
        for(int org = 0; org < tmp;org++) {
            imprimir.print(" ");
            System.out.print(" ");
        }
        for(int j = 0; j < tabela.size();j++) {
            imprimir.print(tabela.get(j) + "   ");
            System.out.print(tabela.get(j) + "   ");
        }
        imprimir.println();
        System.out.println();

        if (raiz.direita != null) {
            exibirEmOrdem(raiz.direita);
        }

    }


    public void exibirPosOrdem() {
        if (raiz != null) {
            exibirPosOrdem(raiz);
            System.out.println();
        }
    }

    private void exibirPosOrdem(No raiz) {
        if (raiz.esquerda != null) {
            exibirPosOrdem(raiz.esquerda);
        }

        if (raiz.direita != null) {
            exibirPosOrdem(raiz.direita);
        }

        System.out.print(raiz.valor + " ");
    }

    public void abc(HashMap map) {
        a = map;
    }
}