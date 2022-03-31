package servicos;

import entidades.Analise;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface IAnaliseServico {

    @WebMethod
    void inserirAnalise(@WebParam(name = "analise") Analise analise);

    @WebMethod
    List<Analise> listarAnalise();

    @WebMethod
    void excluirAnalise(@WebParam(name = "ana_id") Integer id);

    @WebMethod
    void editarAnalise(@WebParam(name = "analise") Analise analise);

    @WebMethod
    Analise buscarAnalisePorId(@WebParam(name = "ana_id") Integer id);


}