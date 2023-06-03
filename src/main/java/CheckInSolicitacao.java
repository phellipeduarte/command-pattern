import java.security.InvalidParameterException;

public class CheckInSolicitacao implements Solicitacao {

    private Quarto quarto;

    public CheckInSolicitacao(Quarto quarto) {
        this.quarto = quarto;
    }


    @Override
    public void atender() {
        if (this.quarto.getOcupado()){
            throw new InvalidParameterException("Quarto já ocupado");
        }else{
            this.quarto.reservarQuarto();
        }

    }

    @Override
    public void cancelar() {
        this.quarto.liberarQuarto();
    }
}
