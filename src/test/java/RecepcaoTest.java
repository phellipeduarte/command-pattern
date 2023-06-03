import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class RecepcaoTest {

    Recepcao recepcao;
    Quarto quarto;

    @BeforeEach
    void setUp(){
        recepcao = new Recepcao();
        quarto = new Quarto(505);
    }

    @Test
    void deveOcuparQuarto(){
        Solicitacao checkIn = new CheckInSolicitacao(quarto);
        recepcao.atenderSolicitacao(checkIn);

        assertEquals("Quarto ocupado", quarto.getStatus());
    }

    @Test
    void deveDesocuparQuarto(){
        Solicitacao checkOut = new CheckOutSolicitacao(quarto);
        recepcao.atenderSolicitacao(checkOut);

        assertEquals("Quarto livre", quarto.getStatus());
    }

    @Test
    void deveCancelarReservaQuarto(){
        Solicitacao checkIn = new CheckInSolicitacao(quarto);
        Solicitacao checkOut =  new CheckOutSolicitacao(quarto);

        recepcao.atenderSolicitacao(checkIn);
        recepcao.atenderSolicitacao(checkOut);

        recepcao.calcelarUltimaSolicitacao();

        assertEquals("Quarto ocupado", quarto.getStatus());
    }

    @Test
    void deveRetornarExcecaoCheckInQuartoOcupado(){
        Solicitacao checkIn1 = new CheckInSolicitacao(quarto);
        Solicitacao checkIn2 = new CheckInSolicitacao(quarto);
        recepcao.atenderSolicitacao(checkIn1);

        try{
            recepcao.atenderSolicitacao(checkIn2);
            fail();
        }catch (InvalidParameterException exception){
            assertEquals("Quarto já ocupado", exception.getMessage());
        }
    }
}
