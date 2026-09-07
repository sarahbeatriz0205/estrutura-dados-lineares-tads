package arvore_avl;

import arvore_binaria.NoArvore;

public class TesteArvoreAVL {

    public static void main(String[] args) {

        ArvoreAVL arvore = new ArvoreAVL(30);

        System.out.println("=================================");
        System.out.println("       TESTE DA ÁRVORE AVL");
        System.out.println("=================================");

        System.out.println("\nÁrvore inicial:");
        arvore.imprimirArvore();

        System.out.println("\nInserindo 20:");
        arvore.insert(20, arvore.raiz);
        arvore.imprimirArvore();

        System.out.println("\nInserindo 10:");
        arvore.insert(10, arvore.raiz);
        arvore.imprimirArvore();

        System.out.println("\nInserindo 40:");
        arvore.insert(40, arvore.raiz);
        arvore.imprimirArvore();

        System.out.println("\nInserindo 50:");
        arvore.insert(50, arvore.raiz);
        arvore.imprimirArvore();

        System.out.println("\nInserindo 25:");
        arvore.insert(25, arvore.raiz);
        arvore.imprimirArvore();

        System.out.println("\n=================================");
        System.out.println("             BUSCA");
        System.out.println("=================================");

        System.out.println("\nBuscando 25:");
        NoArvore no = arvore.search(25, arvore.raiz);
        System.out.println("Nó encontrado: " + no.getElemento());

        System.out.println("\nBuscando 50:");
        no = arvore.search(50, arvore.raiz);
        System.out.println("Nó encontrado: " + no.getElemento());

        System.out.println("\nBuscando 100:");
        no = arvore.search(100, arvore.raiz);

        if (no.getElemento() == 100) {
            System.out.println("Nó encontrado: " + no.getElemento());
        } else {
            System.out.println("Nó não encontrado.");
        }

        System.out.println("\n=================================");
        System.out.println("            REMOÇÃO");
        System.out.println("=================================");

        no = arvore.search(10, arvore.raiz);

        System.out.println("\nRemovendo 10:");
        arvore.remove(no);
        arvore.imprimirArvore();

        no = arvore.search(40, arvore.raiz);

        System.out.println("\nRemovendo 40:");
        arvore.remove(no);
        arvore.imprimirArvore();
    }
}