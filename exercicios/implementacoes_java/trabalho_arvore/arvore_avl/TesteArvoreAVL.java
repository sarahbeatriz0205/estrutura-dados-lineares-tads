package arvore_avl;

import arvore_binaria.NoArvore;

public class TesteArvoreAVL {

    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL(10);

        System.out.println("Teste - Árvore AVL");
        System.out.println("Exemplo de AVL - método mostrar (com as chaves e FB de cada nó)");

        arvore.insert(5, arvore.raiz);
        arvore.insert(15, arvore.raiz);
        arvore.insert(2, arvore.raiz);
        arvore.insert(8, arvore.raiz);
        arvore.insert(22, arvore.raiz);

        System.out.println("\nA árvore abaixo foi resultado de várias inserções e/ou remoções, USANDO O MÉTODO MOSTRAR.");
        arvore.imprimirArvore();
        
        System.out.println("\nContinuando a inserir e/ou remover");
        System.out.println("Inserir 25");
        arvore.insert(25, arvore.raiz);
        
        System.out.println("\nÁrvore depois da inserção do 25 + rotação S.E. em 15");
        arvore.imprimirArvore();

        System.out.println("\nremover 5");
        // Buscamos o nó 5 primeiro para poder passar para o método de remoção
        NoArvore noParaRemover = arvore.search(5, arvore.raiz);
        if (noParaRemover != null) {
            arvore.remove(noParaRemover);
        }
        arvore.imprimirArvore();
    }
}