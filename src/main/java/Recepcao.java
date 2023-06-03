import java.util.ArrayList;
import java.util.List;

public class Recepcao {

    private List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();

    public void atenderSolicitacao(Solicitacao solicitacao){
        this.solicitacoes.add(solicitacao);
        solicitacao.atender();
    }

    public void calcelarUltimaSolicitacao(){
        if(solicitacoes.size() > 0){
            Solicitacao solicitacao = this.solicitacoes.remove(this.solicitacoes.size() - 1);
            solicitacao.cancelar();
        }
    }

}
