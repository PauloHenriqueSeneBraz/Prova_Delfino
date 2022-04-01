import jakarta.xml.ws.Endpoint;
import servicos.AnaliseServico;
import servicos.CompraServico;
import servicos.DesenvolvedorServico;

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


    }
}
