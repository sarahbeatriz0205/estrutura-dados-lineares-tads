package arvore_rb;
import arvore_binaria.ArvoreBinariaDePesquisa;
import arvore_binaria.NoArvore;
import arvore_avl.ArvoreAVL; // ainda vai ser usada pra as rotações

/* 
    1 - Se v é nó externo , v é negro
    2 - O nó raiz é negro
    3 - Se v é rubro, então ambos os filhos são negros
    4 - Os caminhos de v para seus nós descendentes externos possuem idêntico número de nós negros
*/

public class RubroNegra extends ArvoreBinariaDePesquisa{
    public RubroNegra(int raiz){
        super(raiz);
        this.raiz = transformarNo(raiz);
    }

    @Override 
    protected NoRubroNegro transformarNo(int elemento){
        return new NoRubroNegro(null, null, null, elemento);
    }

    /*
        Suponha w(pai de v) rubro e t, o pai
        de w(avó de v) é negro. Se u, o irmão de w
        (tio de v) é rubro, ainda é possível manter o
        critério IV apenas fazendo a re-coloração de
        t(Rubro),u(Negro) e w(Negro)
    */
    private void executaCasoDoisPosInsercao(NoRubroNegro no){
        NoRubroNegro paiDeNo = no.getPai();
        NoRubroNegro avoDeNo = paiDeNo.getPai();
        NoRubroNegro irmaoDoPai;
        if (paiDeNo.getElemento() < avoDeNo.getElemento()){
            irmaoDoPai = avoDeNo.getFilhoDireito();
        }
        else {
            irmaoDoPai = avoDeNo.getFilhoEsquerdo();
        }

        if (paiDeNo.getElemento() == 1 && avoDeNo.getCor() == 0 && irmaoDoPai.getCor() == 1){
            avoDeNo.setCor(1);
            irmaoDoPai.setCor(0);
            paiDeNo.setCor(0);
        }
        else if (paiDeNo.getElemento() == 1 && avoDeNo.getCor() == 1 && irmaoDoPai.getCor() == 1){
            // não entendi essa condição, perguntar pra coleguinha próxima aula
            // Se o pai de t for rubro o processo deverá ser repetido fazendo v=t
        }
    }
    
    // fazer as verificações de qual caso usar dentro do insert
    @Override 
    public NoRubroNegro insert(int elemento, NoArvore no){
        NoRubroNegro inserido = (NoRubroNegro) super.insert(elemento, no);
        return inserido;
    }
}
