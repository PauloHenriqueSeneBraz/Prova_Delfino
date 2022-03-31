import jakarta.xml.ws.Endpoint;
import servicos.AnaliseServico;
import servicos.CompraServico;

public class Aplicacao {

    public static void main(String[] args){
        Endpoint.publish(
                "http://localhost:8080/analise-servidor",
                new AnaliseServico()
        );
        Endpoint.publish(
                "http://localhost:8080/compra-servidor",
                new CompraServico()
        );


    }
}
