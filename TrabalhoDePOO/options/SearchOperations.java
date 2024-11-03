package options;

public class SearchOperations {
    VetorOperations vetorOps = new VetorOperations();

    public void pesquisaSequencial() {
        if (VetorOperations.vetorOriginal == null) {
            System.out.println("Vetor não criado.");
            return;
        }

        System.out.print("Informe o valor a ser pesquisado: ");
        int valor = VetorOperations.scanner.nextInt();

        int contador = 0;
        for (int i = 0; i < VetorOperations.vetorOriginal.length; i++) {
            contador++;
            if (VetorOperations.vetorOriginal[i] == valor) {
                System.out.println("Valor encontrado na posição: " + i);
                System.out.println("Número de comparações: " + contador);
                return;
            }
        }
        System.out.println("Valor não encontrado.");
        System.out.println("Número de comparações: " + contador);
    }

    public void pesquisaSequencialMelhorada() {
        if (VetorOperations.vetorOriginal == null) {
            System.out.println("Vetor não criado.");
            return;
        }

        vetorOps.criarVetorOrdenadoTemporario();

        System.out.print("Informe o valor a ser pesquisado: ");
        int valor = VetorOperations.scanner.nextInt();

        int contador = 0;
        int valorMaisProximo = VetorOperations.vetorOrdenado[0];
        for (int i = 0; i < VetorOperations.vetorOrdenado.length && valor >= VetorOperations.vetorOrdenado[i]; i++) {
            contador++;
            if (VetorOperations.vetorOrdenado[i] == valor) {
                System.out.println("Valor encontrado na posição: " + i);
                System.out.println("Número de comparações: " + contador);
                return;
            }
            valorMaisProximo = VetorOperations.vetorOrdenado[i];
        }

        System.out.println("Valor não encontrado.");
        System.out.println("Número mais próximo: " + valorMaisProximo);
        System.out.println("Número de comparações: " + contador);
    }

    public void pesquisaBinaria() {
        if (VetorOperations.vetorOriginal == null) {
            System.out.println("Vetor não criado.");
            return;
        }

        vetorOps.criarVetorOrdenadoTemporario();

        System.out.print("Informe o valor a ser pesquisado: ");
        int valor = VetorOperations.scanner.nextInt();

        int contador = 0;
        int inicio = 0;
        int fim = VetorOperations.vetorOrdenado.length - 1;
        while (inicio <= fim) {
            contador++;
            int meio = (inicio + fim) / 2;

            if (VetorOperations.vetorOrdenado[meio] == valor) {
                System.out.println("Valor encontrado na posição: " + meio);
                System.out.println("Número de comparações: " + contador);
                return;
            } else if (VetorOperations.vetorOrdenado[meio] < valor) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        System.out.println("Valor não encontrado.");
        System.out.println("Número de comparações: " + contador);
    }

    public void compararAlgoritmos() {
        if (VetorOperations.vetorOriginal == null) {
            System.out.println("Vetor não criado.");
            return;
        }

        System.out.print("Informe o valor a ser pesquisado: ");
        int valor = VetorOperations.scanner.nextInt();

        long startTime = System.nanoTime();
        int contadorSeq = pesquisaSequencialComparar(valor);
        long endTime = System.nanoTime();
        long tempoSequencial = (endTime - startTime);

        vetorOps.criarVetorOrdenadoTemporario();
        startTime = System.nanoTime();
        int contadorBin = pesquisaBinariaComparar(valor);
        endTime = System.nanoTime();
        long tempoBinario = (endTime - startTime);

        System.out.println("Tempo de execução (Sequencial): " + tempoSequencial + " ns");
        System.out.println("Número de comparações (Sequencial): " + contadorSeq);
        System.out.println("Tempo de execução (Binária): " + tempoBinario + " ns");
        System.out.println("Número de comparações (Binária): " + contadorBin);
    }

    private int pesquisaSequencialComparar(int valor) {
        int contador = 0;
        for (int i = 0; i < VetorOperations.vetorOriginal.length; i++) {
            contador++;
            if (VetorOperations.vetorOriginal[i] == valor) {
                return contador;
            }
        }
        return contador;
    }

    private int pesquisaBinariaComparar(int valor) {
        int contador = 0;
        int inicio = 0;
        int fim = VetorOperations.vetorOrdenado.length - 1;
        while (inicio <= fim) {
            contador++;
            int meio = (inicio + fim) / 2;

            if (VetorOperations.vetorOrdenado[meio] == valor) {
                return contador;
            } else if (VetorOperations.vetorOrdenado[meio] < valor) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return contador;
    }
}
