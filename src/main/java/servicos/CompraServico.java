package servicos;

import entidades.Compra;
import jakarta.jws.WebService;
import repositorios.CompraRepositorio;

import java.util.List;

@WebService(endpointInterface = "servicos.ICompraServico")

public class CompraServico implements ICompraServico {

    private CompraRepositorio compraRepositorio = new CompraRepositorio();

    @Override
    public void inserirCompra(Compra compra) {
        compraRepositorio.inserir(compra);
    }

    @Override
    public List<Compra> listarCompra() {
        return compraRepositorio.listar();
    }

    @Override
    public void excluirCompra(Integer id) {
        compraRepositorio.excluir(id);
    }

    @Override
    public void editarCompra(Compra compra) {
        compraRepositorio.editar(compra);
    }

    @Override
    public Compra buscarCompraPorId(Integer id) {
        return compraRepositorio.buscarPorId(id);
    }
}
