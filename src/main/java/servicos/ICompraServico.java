package servicos;

import entidades.Compra;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface ICompraServico {

    @WebMethod
    void inserirCompra(@WebParam(name = "compra") Compra compra);

    @WebMethod
    List<Compra> listarCompra();

    @WebMethod
    void excluirCompra(@WebParam(name = "com_id") Integer id);

    @WebMethod
    void editarCompra(@WebParam(name = "compra") Compra compra);

    @WebMethod
    Compra buscarCompraPorId(@WebParam(name = "com_id") Integer id);

}
