package servicos;

import entidades.Jogo;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface IJogoServico {

    @WebMethod
    void inserirJogo(@WebParam(name = "jogo") Jogo jogo);

    @WebMethod
    List<Jogo> listarJogos();

    @WebMethod
    void excluirJogo(@WebParam(name = "jog_id") Integer id);

    @WebMethod
    void editarJogo(@WebParam(name = "jogo") Jogo jogo);

    @WebMethod
    Jogo buscarJogoPorId(@WebParam(name = "jog_id") Integer id);
}
