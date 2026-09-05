package arvore_avl;
import arvore_binaria.ArvoreBinariaDePesquisa;

public class ArvoreAVL extends ArvoreBinariaDePesquisa{

    public ArvoreAVL(int elemento){
        super(elemento);
    }

    public String rebalancear(NoAVL noDesbalanceado, NoAVL noFilho){
        if (noDesbalanceado.getFB() == -2 && noFilho.getFB() <= 0){
            rotacionaEsquerdaSimples(noDesbalanceado, noFilho);
            return "Rebalanceado com sucesso!";
        }
        else if (noDesbalanceado.getFB() == 2 && noFilho.getFB() >= 0){
            rotacionaDireitaSimples(noDesbalanceado, noFilho);
            return "Rebalanceado com sucesso!";
        }
        else if (noDesbalanceado.getFB() == -2 && noFilho.getFB() >= 0){
            rotacionaDireitaDupla(noDesbalanceado, noFilho);
            return "Rebalanceado com sucesso!";
        }
        else if (noDesbalanceado.getFB() == 2 && noFilho.getFB() <= 0){
            rotacionaEsquerdaDupla(noDesbalanceado, noFilho);
            return "Rebalanceado com sucesso!";
        }
        else {
            return "Já está balanceado! Não precisa de rotação.";
        }
    }

    public void atualizaFatorBalanceamentoPosRotacaoEsquerda(NoAVL noDesbalanceado, NoAVL noFilho){
        int fbNoB = noDesbalanceado.getFB();
        int fbNoA = noFilho.getFB();
        int fbNoBNovo= fbNoB + 1 - Math.max(fbNoA, 0);
        int fbNoANovo= fbNoA + 1 + Math.min(fbNoBNovo, 0);
        noDesbalanceado.setFB(fbNoBNovo);
        noFilho.setFB(fbNoANovo);
    }

    public void atualizaFatorBalanceamentoPosRotacaoDireita(NoAVL noDesbalanceado, NoAVL noFilho){
        int fbNoB = noDesbalanceado.getFB();
        int fbNoA = noFilho.getFB();
        int fbNoBNovo= fbNoB - 1 - Math.max(fbNoA, 0);
        int fbNoANovo= fbNoA - 1 + Math.min(fbNoBNovo, 0);
        noDesbalanceado.setFB(fbNoBNovo);
        noFilho.setFB(fbNoANovo);
    }

    private void rotacionaEsquerdaSimples(NoAVL noDesbalanceado, NoAVL noFilho){ 
        if (noFilho.getFilhoEsquerdo() == null && isRoot(noDesbalanceado)){
            noFilho.setFilhoEsquerdo(noDesbalanceado);
            noDesbalanceado.setPai(noFilho);
            noFilho.setPai(null);
            this.raiz = noFilho;
            atualizaFatorBalanceamentoPosRotacaoEsquerda(noDesbalanceado, noFilho);
            return;
        }
        else if (!isRoot(noDesbalanceado) && noFilho.getFilhoEsquerdo() != null){
            NoAVL antigoPai = (NoAVL) noDesbalanceado.getPai();
            NoAVL filhoEsq = (NoAVL) noFilho.getFilhoEsquerdo();
            noFilho.setFilhoEsquerdo(noDesbalanceado);
            if (noDesbalanceado.getElemento() < noDesbalanceado.getPai().getElemento()){
                noDesbalanceado.getPai().setFilhoEsquerdo(noFilho);
            }
            else {
                noDesbalanceado.getPai().setFilhoDireito(noFilho);
            }
            noDesbalanceado.setPai(noFilho);
            noDesbalanceado.setFilhoDireito(filhoEsq);
            filhoEsq.setPai(noDesbalanceado);
            noFilho.setPai(antigoPai);
            atualizaFatorBalanceamentoPosRotacaoEsquerda(noDesbalanceado, noFilho);
            return;
        }
        else if(isRoot(noDesbalanceado) && noFilho.getFilhoEsquerdo() != null){
            NoAVL filhoEsq = (NoAVL) noFilho.getFilhoEsquerdo();
            noFilho.setFilhoEsquerdo(noDesbalanceado);
            noDesbalanceado.setPai(noFilho);
            noDesbalanceado.setFilhoDireito(filhoEsq);
            filhoEsq.setPai(noDesbalanceado);
            noFilho.setPai(null);
            this.raiz = noFilho;
            atualizaFatorBalanceamentoPosRotacaoEsquerda(noDesbalanceado, noFilho);
            return;
        }
        else if (noFilho.getFilhoEsquerdo() == null && !isRoot(noDesbalanceado)){
            NoAVL antigoPai = (NoAVL) noDesbalanceado.getPai();
            noFilho.setFilhoEsquerdo(noDesbalanceado);
            if (noDesbalanceado.getElemento() < noDesbalanceado.getPai().getElemento()){
                noDesbalanceado.getPai().setFilhoEsquerdo(noFilho);
            }
            else {
                noDesbalanceado.getPai().setFilhoDireito(noFilho);
            }
            noDesbalanceado.setPai(noFilho);
            noFilho.setPai(antigoPai);
            atualizaFatorBalanceamentoPosRotacaoEsquerda(noDesbalanceado, noFilho);
            return;
        }
    }

    private void rotacionaDireitaSimples(NoAVL noDesbalanceado, NoAVL noFilho){ 
        if (noFilho.getFilhoDireito() == null && isRoot(noDesbalanceado)){
            noFilho.setFilhoDireito(noDesbalanceado);
            noDesbalanceado.setPai(noFilho);
            noFilho.setPai(null);
            this.raiz = noFilho;
            atualizaFatorBalanceamentoPosRotacaoDireita(noDesbalanceado, noFilho);
            return;
        }
        else if (!isRoot(noDesbalanceado) && noFilho.getFilhoDireito() != null){
            NoAVL antigoPai = (NoAVL) noDesbalanceado.getPai();
            NoAVL filhoDir = (NoAVL) noFilho.getFilhoDireito();
            noFilho.setFilhoDireito(noDesbalanceado);
            if (noDesbalanceado.getElemento() < noDesbalanceado.getPai().getElemento()){
                noDesbalanceado.getPai().setFilhoEsquerdo(noFilho);
            }
            else {
                noDesbalanceado.getPai().setFilhoDireito(noFilho);
            }
            noDesbalanceado.setPai(noFilho);
            noDesbalanceado.setFilhoEsquerdo(filhoDir);
            filhoDir.setPai(noDesbalanceado);
            noFilho.setPai(antigoPai);
            atualizaFatorBalanceamentoPosRotacaoDireita(noDesbalanceado, noFilho);
            return;
        }
        else if(isRoot(noDesbalanceado) && noFilho.getFilhoDireito() != null){
            NoAVL filhoDir = (NoAVL) noFilho.getFilhoDireito();
            noFilho.setFilhoDireito(noDesbalanceado);
            noDesbalanceado.setPai(noFilho);
            noDesbalanceado.setFilhoEsquerdo(filhoDir);
            filhoDir.setPai(noDesbalanceado);
            noFilho.setPai(null);
            this.raiz = noFilho;
            atualizaFatorBalanceamentoPosRotacaoDireita(noDesbalanceado, noFilho);
            return;
        }
        else if (noFilho.getFilhoDireito() == null && !isRoot(noDesbalanceado)){
            NoAVL antigoPai = (NoAVL) noDesbalanceado.getPai();
            noFilho.setFilhoDireito(noDesbalanceado);
            if (noDesbalanceado.getElemento() < noDesbalanceado.getPai().getElemento()){
                noDesbalanceado.getPai().setFilhoEsquerdo(noFilho);
            }
            else {
                noDesbalanceado.getPai().setFilhoDireito(noFilho);
            }
            noDesbalanceado.setPai(noFilho);
            noFilho.setPai(antigoPai);
            atualizaFatorBalanceamentoPosRotacaoDireita(noDesbalanceado, noFilho);
            return;
        }
    }

    private void rotacionaEsquerdaDupla(NoAVL noDesbalanceado, NoAVL noFilho){ 
        rotacionaDireitaSimples(noFilho, noFilho.getFilhoDireito());
        rotacionaEsquerdaSimples(noDesbalanceado, noFilho);
    }

    private void rotacionaDireitaDupla(NoAVL noDesbalanceado, NoAVL noFilho){ 
        rotacionaEsquerdaSimples(noFilho, noFilho.getFilhoEsquerdo());
        rotacionaDireitaSimples(noDesbalanceado, noFilho);
        atualizaFatorBalanceamentoPosRotacaoDireita(noDesbalanceado, noFilho);
    }

    @Override
    protected NoAVL transformarNo(int e){
        return new NoAVL(null, null, null, e);
    }
}