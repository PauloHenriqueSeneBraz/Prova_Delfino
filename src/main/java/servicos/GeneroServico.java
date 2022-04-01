package servicos;


import entidades.Genero;
import jakarta.jws.WebService;
import repositorios.GeneroRepositorio;

import java.util.List;

@WebService(endpointInterface = "servicos.IGeneroServico")
public class GeneroServico implements IGeneroServico{
    private GeneroRepositorio generoRepositorio = new GeneroRepositorio();

    @Override
    public void inserirGenero(Genero genero) {
        generoRepositorio.inserir(genero);
    }

    @Override
    public List<Genero> listarGenero() {
        return generoRepositorio.listar();
    }

    @Override
    public void excluirGenero(Integer id) {
        generoRepositorio.excluir(id);
    }

    @Override
    public void editarGenero(Genero genero) {
        generoRepositorio.editar(genero);
    }

    @Override
    public Genero buscarGeneroPorId(Integer id) {
        return generoRepositorio.buscarPorId(id);
    }
}
