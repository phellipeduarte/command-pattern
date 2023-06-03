public class CheckOutSolicitacao implements Solicitacao {

    private Quarto quarto;

    public CheckOutSolicitacao(Quarto quarto) {
        this.quarto = quarto;
    }


    @Override
    public void atender() {
        this.quarto.liberarQuarto();
    }

    @Override
    public void cancelar() {
        this.quarto.reservarQuarto();
    }
}
