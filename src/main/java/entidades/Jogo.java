package entidades;

import lombok.Data;

@Data
public class Jogo {
    private Integer jog_id;
    private String jog_titulo;
    private double jog_preco_unitario;
    private Genero jog_gen_idFK;
    private Desenvolvedor jog_dev_idFK;
}
