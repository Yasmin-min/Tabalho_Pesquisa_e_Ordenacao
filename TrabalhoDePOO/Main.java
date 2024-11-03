import java.io.*;
import java.util.Scanner;
import options.HashingOperations;
import options.SearchOperations;
import options.VetorOperations;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static VetorOperations vetorOperations = new VetorOperations();
    static SearchOperations searchOperations = new SearchOperations();
    static HashingOperations hashingOperations = new HashingOperations();

    public static void main(String[] args) throws IOException {
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Criar Vetor");
            System.out.println("2. Ler Arquivo");
            System.out.println("3. Pesquisa Sequencial");
            System.out.println("4. Pesquisa Binária");
            System.out.println("5. Comparar Algoritmos");
            System.out.println("6. Hashing");
            System.out.println("7. Exibir Vetor");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    vetorOperations.criarVetor();
                    break;
                case 2:
                    vetorOperations.lerArquivo();
                    break;
                case 3:
                    searchOperations.pesquisaSequencial();
                    break;
                case 4:
                    searchOperations.pesquisaBinaria();
                    break;
                case 5:
                    searchOperations.compararAlgoritmos();
                    break;
                case 6:
                    hashingOperations.hashing();
                    break;
                case 7:
                    vetorOperations.exibirVetor();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}
