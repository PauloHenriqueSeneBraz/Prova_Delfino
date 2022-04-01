package servicos;

import entidades.Genero;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface IGeneroServico {
    @WebMethod
    void inserirGenero(@WebParam(name = "genero") Genero genero);

    @WebMethod
    List<Genero> listarGenero();

    @WebMethod
    void excluirGenero(@WebParam(name = "gen_id") Integer id);

    @WebMethod
    void editarGenero(@WebParam(name = "genero") Genero genero);

    @WebMethod
    Genero buscarGeneroPorId(@WebParam(name = "gen_id") Integer id);
}
