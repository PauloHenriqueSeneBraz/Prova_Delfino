import entidades.Jogo;
import jakarta.xml.ws.Endpoint;
import servicos.*;

public class Aplicacao {

    public static void main(String[] args){
        Endpoint.publish(
                "http://localhost:8080/analise-servidor?wsdl",
                new AnaliseServico()
        );
        Endpoint.publish(
                "http://localhost:8080/compra-servidor?wsdl",
                new CompraServico()
        );
        Endpoint.publish(
                "http://localhost:8080/desenvolvedor-servidor?wsdl",
                new DesenvolvedorServico()
        );
        Endpoint.publish(
                "http://localhost:8080/genero-servidor?wsdl",
                new GeneroServico()
        );
        Endpoint.publish(
                "http://localhost:8080/jogo-servidor?wsdl",
                new JogoServico()
        );


    }
}
