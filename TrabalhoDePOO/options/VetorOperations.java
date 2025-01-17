package options;
import java.io.*;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VetorOperations {
    static VetorOperations vetorOperations = new VetorOperations();
    static Scanner scanner = new Scanner(System.in);
    static int[] vetorOriginal;
    static int[] vetorOrdenado;

    public void criarVetor() {
        System.out.print("Informe o tamanho do vetor: ");
        int tamanho = scanner.nextInt();
        vetorOriginal = new int[tamanho];

        System.out.println("1. Preencher vetor manualmente");
        System.out.println("2. Preencher vetor com valores aleatórios");
        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();

        if (escolha == 1) {
            for (int i = 0; i < tamanho; i++) {
                System.out.print("Informe o valor para a posição " + i + ": ");
                vetorOriginal[i] = scanner.nextInt();
            }
            vetorOperations.exibirVetor();
        } else {
            Random random = new Random();
            for (int i = 0; i < tamanho; i++) {
                vetorOriginal[i] = random.nextInt(10001);  // Gerar números aleatórios positivos
            }
            System.out.println("Vetor preenchido com valores aleatórios.");
            vetorOperations.exibirVetor();
        }
    }

    public void lerArquivo() throws IOException {
        System.out.print("Carregar o arquivo: ");
        String nomeArquivo = selecionarArquivo();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            List<Integer> lista = new ArrayList<>();
            String linha;
            while ((linha = br.readLine()) != null) {
                lista.add(Integer.parseInt(linha));
            }
            vetorOriginal = lista.stream().mapToInt(i -> i).toArray();
            System.out.println("Vetor carregado do arquivo.");

           
            
           if (vetorOriginal.length <= 200) {
                System.out.println("Exibir vetor:");
                System.out.print("Vetor=[ ");
                
                for (int item:vetorOriginal) {
                    System.out.print(item + ", ");
                }
                System.out.print(" ]");
           } else {
                System.out.println("Vetor muito grande para exibir. Tamanho: " + vetorOriginal.length);
           }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
        }
    }

    public void exibirVetor() {
        if (vetorOriginal == null) {
            System.out.println("Vetor não criado.");
            return;
        }

        System.out.println("Vetor original: " + Arrays.toString(vetorOriginal));
        if (vetorOrdenado != null) {
            System.out.println("Vetor temporário ordenado (se utilizado): " + Arrays.toString(vetorOrdenado));
        }
    }

    public void criarVetorOrdenadoTemporario() {
        vetorOrdenado = vetorOriginal.clone();
        Arrays.sort(vetorOrdenado);
        System.out.println("Vetor temporário foi ordenado.");
    }

    public static String selecionarArquivo() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Texto", "txt");
		fileChooser.setFileFilter(filter);
		
		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			return selectedFile.getAbsolutePath();
		}
		return null;
	}
}
