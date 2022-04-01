package entidades;

import lombok.Data;

@Data
public class Analise {
    private Integer ana_id;
    private String ana_data;
    private String ana_titulo;
    private String ana_descricao;
    private String ana_situacao;
    private Usuario ana_usu_idFK;
    private Jogo ana_jog_idFK;

}
