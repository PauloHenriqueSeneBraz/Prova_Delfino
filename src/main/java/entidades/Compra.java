package entidades;

import lombok.Data;

import java.util.Date;

@Data
public class Compra {

    private Integer com_id;
    private Date com_horario;
    private double com_preco_total;
    private Usuario com_usu_id;
    private Jogo com_jog_id;
}
