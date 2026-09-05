package arvore_avl;
import arvore_binaria.NoArvore;

public class NoAVL extends NoArvore{
    private int fb;

    public NoAVL(NoAVL filhoEsquerdo, NoAVL filhoDireito, NoAVL pai, int o){
        super(filhoEsquerdo, filhoDireito, pai, o);
        this.fb = 0;
    }

    @Override
    public NoAVL getFilhoEsquerdo(){
        return (NoAVL) this.filhoEsquerdo;
    }

    @Override
    public NoAVL getFilhoDireito(){
        return (NoAVL) this.filhoDireito;
    }
    
    @Override
    public NoAVL getPai(){
        return (NoAVL) this.pai;
    }

    public int getElemento(){
        return this.elemento;
    }

    public void setFilhoEsquerdo(NoArvore v){
        this.filhoEsquerdo = v;
    }

    public void setFilhoDireito(NoArvore v){
        this.filhoDireito = v;
    }

    public void setPai(NoArvore v){
        this.pai = v;
    }

    public int getFB(){
        return this.fb;
    }

    public void setFB(int novoFB){
        this.fb = novoFB;
    }
}