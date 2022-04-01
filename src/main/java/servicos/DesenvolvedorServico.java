package servicos;

import entidades.Desenvolvedor;
import jakarta.jws.WebService;
import repositorios.DesenvolvedorRepositorio;

import java.util.List;

@WebService(endpointInterface = "servicos.IDesenvolvedorServico")

public class DesenvolvedorServico implements IDesenvolvedorServico{
    private DesenvolvedorRepositorio desenvolvedorRepositorio = new DesenvolvedorRepositorio();

    @Override
    public void inserirDesenvolvedor(Desenvolvedor desenvolvedor) {
        desenvolvedorRepositorio.inserir(desenvolvedor);
    }

    @Override
    public List<Desenvolvedor> listarDesenvolvedor() {
        return desenvolvedorRepositorio.listar();
    }

    @Override
    public void excluirDesenvolvedor(Integer id) {
        desenvolvedorRepositorio.excluir(id);
    }

    @Override
    public void editarDesenvolvedor(Desenvolvedor desenvolvedor) {
        desenvolvedorRepositorio.editar(desenvolvedor);
    }

    @Override
    public Desenvolvedor buscarDesenvolvedorPorId(Integer id) {
        return desenvolvedorRepositorio.buscarPorId(id);
    }
        }
