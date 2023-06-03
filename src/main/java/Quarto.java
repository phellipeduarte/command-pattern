public class Quarto {

    private Integer numero;
    private Boolean ocupado = false;

    public Quarto(Integer numero) {
        this.numero = numero;
    }

    public Quarto(Integer numero, Boolean ocupado) {
        this.numero = numero;
        this.ocupado = ocupado;
    }

    public String getStatus(){
        if (ocupado){
            return "Quarto ocupado";
        }else{
            return "Quarto livre";
        }
    }

    public Boolean getOcupado() {
        return ocupado;
    }

    public void liberarQuarto(){ this.ocupado = false; }

    public void reservarQuarto(){ this.ocupado = true; }

}
