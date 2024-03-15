package java_poo.heranca_polimorfismo.desafio_01;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;

// Criação e herança de classe:
public class Expresso extends Pedido {
    
    // Construtor:
    public Expresso(Integer codPedido, LocalDate dataPedido, String nomeCliente, String enderCliente, Produto[] listaItens, Double frete){
        super(codPedido, dataPedido, nomeCliente, enderCliente, listaItens, frete);
    }

    // Polimorfismo:
    @Override
    public void calculoValorTotal(){
        Double valorTotal = 0.00;
        Double valorFrete = 0.00;
        Double pesoProduto = 0.00;

        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.DOWN);

        if (this.listaItens.length >= 1){
            for (Produto produto : this.listaItens){
                valorTotal += (produto.getPreco() * produto.getQuantidade());
                pesoProduto = produto.getPeso();
                
                if (pesoProduto <= 1.00){
                    valorFrete += (produto.getQuantidade() * (produto.getPeso() * 15.00));
                } else if (pesoProduto > 1.00 && pesoProduto <= 5.00){
                    valorFrete += (produto.getQuantidade() * (produto.getPeso() * 12.50));
                } else if (pesoProduto > 5.00 && pesoProduto <= 10.00){
                    valorFrete += (produto.getQuantidade() * (produto.getPeso() * 10.00));
                } else if (pesoProduto > 10.00 && pesoProduto <= 20.00){
                    valorFrete += (produto.getQuantidade() * (produto.getPeso() * 8.70));
                } else if (pesoProduto > 20.00){
                    valorFrete += (produto.getQuantidade() * (produto.getPeso() * 7.50));
                } else {
                    valorFrete += 0.00;
                }
            }
        }

        valorTotal = valorTotal + valorFrete;

        System.out.println("Valor total do pedido: "+ df.format(valorTotal) +" | Frete por peso!");
    }

    // Método para exibir informações do pedido:
    public void exibirInfoPedido(){
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.DOWN);
        
        System.out.println("- Código do pedido: "+ this.codPedido);
        System.out.println("- Data do pedido: "+ this.dataPedido);
        System.out.println("- Nome do cliente: "+ this.nomeCliente);
        System.out.println("- Endereço do cliente: "+ this.enderCliente);
        System.out.println("_______________________________________");
        System.out.println("- Tabela de tarifa (Frete):");
        System.out.println("Até 1kg = R$15,00");
        System.out.println("1kg até 5kg = R$12,50");
        System.out.println("5kg até 10kg = R$10,00");
        System.out.println("10kg até 20kg  = R$8,70");
        System.out.println("Mais de 20kg = R$7,50");
        System.out.println("_______________________________________");
        System.out.println("- Lista de itens: ");

        if (this.listaItens.length >= 1){
            for (Produto produto : this.listaItens){
                System.out.println("Nome: "+ produto.getNome() +" | Preço: "+ df.format(produto.getPreco()) +" | Quantidade: "+ produto.getQuantidade());
            }
        }
    }
}