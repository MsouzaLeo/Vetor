package vetor;

/**
 *
 * @author leonardo
 */
import javax.swing.*;

public class Vetor {

    public static void main(String[] args) {
        JTextArea saidaArea = new JTextArea();
        final int TAM_VET = 10;
        int vet[] = new int[TAM_VET];
        int num;
        String vetor, numero;
        for (int i = 0; i < vet.length; i++) {
            vetor = JOptionPane.showInputDialog("Digite o " + (i + 1) + "º " + "valor do vetor");
            vet[i] = Integer.parseInt(vetor);
        }

        inverteVetor(vet);

        String saida = "Itens do array na ordem invertida\n";
        for (int counter = 0; counter < vet.length; counter++) {
            saida += "  " + vet[counter];
        }

        bubbleSort(vet);

        saida += "\n\nItens do array em ordem ascendente\n";
        // acrescenta valores ordenados do array ao String saida
        for (int counter = 0; counter < vet.length; counter++) {
            saida += "  " + vet[counter];
        }
        saidaArea.setText(saida);
        JOptionPane.showMessageDialog(null, saidaArea, "Programa de ordenação dos elementos de um array", JOptionPane.INFORMATION_MESSAGE);

        numero = JOptionPane.showInputDialog("Digite o numero a ser buscado no vetor" );
        num = Integer.parseInt(numero);
        
        if(buscaBinaria(vet, num)>=0)
            JOptionPane.showMessageDialog(null,"Valor encontradono indice: " + buscaBinaria(vet, num));
        else
            JOptionPane.showMessageDialog(null,"Valor não encontrado no vetor");
    }
    
    //invert
    public static int[] inverteVetor(int vet[]) {
        int aux;
        for (int i = 0; i < vet.length; i++) {
            for (int j = 0; j < i; j++) {
                aux = vet[i];
                vet[i] = vet[j];
                vet[j] = aux;
            }
        }
        return vet;
    }

    //bolha
    public static int[] bubbleSort(int vet[]) {
        for (int i = vet.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (vet[j - 1] > vet[j]) {
                    int aux = vet[j];
                    vet[j] = vet[j - 1];
                    vet[j - 1] = aux;
                }
            }
        }
        return vet;
    }

    //busca binaria
    private static int buscaBinaria(int[] vet, int num) {
        int esq = 0, meio;
        int dir = vet.length;
        
        while(esq<=dir){
            meio = (esq + dir)/2;
            if(vet[meio]== num)
                return meio;
            else if(vet[meio] < num) esq = meio++;
            else if(vet[meio] >  num) dir = meio--;
        }
        return -1;
    }

}
