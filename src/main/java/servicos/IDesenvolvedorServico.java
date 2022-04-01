package servicos;

import entidades.Desenvolvedor;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface IDesenvolvedorServico {
    @WebMethod
    void inserirDesenvolvedor(@WebParam(name = "desenvolvedor") Desenvolvedor desenvolvedor);

    @WebMethod
    List<Desenvolvedor> listarDesenvolvedor();

    @WebMethod
    void excluirDesenvolvedor(@WebParam(name = "dev_id") Integer id);

    @WebMethod
    void editarDesenvolvedor(@WebParam(name = "desenvolvedor") Desenvolvedor desenvolvedor);

    @WebMethod
    Desenvolvedor buscarDesenvolvedorPorId(@WebParam(name = "dev_id") Integer id);
}
