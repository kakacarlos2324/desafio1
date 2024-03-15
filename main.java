package java_poo.heranca_polimorfismo.desafio_01;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        // Pedido normal:
        System.out.println("                                                               ");
        System.out.println("Pedido Normal:");
        System.out.println("                                                               ");

        Cliente cliente01 = new Cliente("Eduardo", "Rua Albedo Rios N°77");

        Produto[] listaProdutos01 = new Produto[3];
    
        listaProdutos01[0] = new Produto("Shampoo Anti-Calvice", 15.90, 3, 1.00);
        listaProdutos01[1] = new Produto("Entendendo Algoritmos (livro)", 51.70, 1, 2.50);
        listaProdutos01[2] = new Produto("Memória RAM 16GB", 199.99, 2, 0.70);

        LocalDate data = LocalDate.now();
        
        Pedido pedidoCliente = new Pedido(1488, data, cliente01.getNome(), cliente01.getEndereco(), listaProdutos01, 15.00);

        pedidoCliente.exibirInfoPedido();
        pedidoCliente.calculoValorTotal();

        // Pedido expresso:
        System.out.println("                                                               ");
        System.out.println("Pedido Expresso:");
        System.out.println("                                                               ");
        
        Cliente cliente02 = new Cliente("Gustavo", "Rua Molduras Goias N°98");

        Produto[] listaProdutos02 = new Produto[3];

        listaProdutos02[0] = new Produto("Camisa da França", 249.90, 1, 0.20);
        listaProdutos02[1] = new Produto("AirPods", 480.00, 2, 0.75);
        listaProdutos02[2] = new Produto("Cueca", 15.75, 6, 0.12);

        Expresso pedidoClienteExpresso = new Expresso(8511, data, cliente02.getNome(), cliente02.getEndereco(), listaProdutos02, 0.00);

        pedidoClienteExpresso.exibirInfoPedido();
        pedidoClienteExpresso.calculoValorTotal();
        
        // Pedido retirado da loja:
        System.out.println("                                                               ");
        System.out.println("Pedido Retirado da Loja:");
        System.out.println("                                                               ");

        Cliente cliente03 = new Cliente("Lucas", "Rua Patagônia de Souza N°16");

        Produto[] listaProdutos03 = new Produto[3];

        listaProdutos03[0] = new Produto("Estetoscópio", 349.90, 1, 1.50);
        listaProdutos03[1] = new Produto("Pacote de café Java", 25.00, 4, 0.75);
        listaProdutos03[2] = new Produto("Luz de LED RGB", 24.00, 2, 0.30);

        RetiradaLoja PedidoClienteRetiradaLoja = new RetiradaLoja(9127, data, cliente03.getNome(), cliente03.getEndereco(), listaProdutos03, 0.00);

        PedidoClienteRetiradaLoja.exibirInfoPedido();
        PedidoClienteRetiradaLoja.calculoValorTotal();;
    }
    
}