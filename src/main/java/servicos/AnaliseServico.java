package servicos;

import entidades.Analise;
import jakarta.jws.WebService;
import repositorios.AnaliseRepositorio;

import java.util.List;

@WebService(endpointInterface = "servicos.IAnaliseServico")
public class AnaliseServico implements IAnaliseServico {
    private AnaliseRepositorio analiseRepositorio = new AnaliseRepositorio();

    @Override
    public void inserirAnalise(Analise analise) {
        analiseRepositorio.inserir(analise);
    }

    @Override
    public List<Analise> listarAnalise() {
        return analiseRepositorio.listar();
    }

    @Override
    public void excluirAnalise(Integer id) {
        analiseRepositorio.excluir(id);
    }

    @Override
    public void editarAnalise(Analise analise) {
        analiseRepositorio.editar(analise);
    }

    @Override
    public Analise buscarAnalisePorId(Integer id) {
        return analiseRepositorio.buscarPorId(id);
    }
}
