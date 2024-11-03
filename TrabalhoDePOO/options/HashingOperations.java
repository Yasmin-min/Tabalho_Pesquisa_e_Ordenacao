package options;
import java.util.HashSet;
import java.util.Set;

public class HashingOperations {
    public void hashing() {
        if (VetorOperations.vetorOriginal == null) {
            System.out.println("Vetor não criado.");
            return;
        }

        System.out.print("Informe o valor a ser pesquisado: ");
        int valor = VetorOperations.scanner.nextInt();

        Set<Integer> hashSet = new HashSet<>();
        for (int v : VetorOperations.vetorOriginal) {
            hashSet.add(v);
        }

        if (hashSet.contains(valor)) {
            System.out.println("Valor encontrado na tabela hash.");
        } else {
            System.out.println("Valor não encontrado na tabela hash.");
        }
    }
}
