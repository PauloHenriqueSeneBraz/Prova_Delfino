package servicos;

import entidades.Jogo;
import jakarta.jws.WebService;
import repositorios.JogoRepositorio;

import java.util.List;

@WebService(endpointInterface = "servicos.IJogoServico")
public class JogoServico implements IJogoServico {
    private JogoRepositorio jogoRepositorio = new JogoRepositorio();

    @Override
    public void inserirJogo(Jogo jogo) {
        jogoRepositorio.inserir(jogo);
    }

    @Override
    public List<Jogo> listarJogos() {
        return jogoRepositorio.listar();
    }

    @Override
    public void excluirJogo(Integer id) {
        jogoRepositorio.excluir(id);
    }

    @Override
    public void editarJogo(Jogo jogo) {
        jogoRepositorio.editar(jogo);
    }

    @Override
    public Jogo buscarJogoPorId(Integer id) {
        return jogoRepositorio.buscarPorId(id);
    }
}
