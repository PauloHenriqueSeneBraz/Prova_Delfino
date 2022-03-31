package entidades;

import lombok.Data;

@Data
public class Usuario {
    private Integer usu_id;
    private String usu_nome;
    private String usu_cpf;
    private String usu_email;
    private String usu_senha;
}
