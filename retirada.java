package java_poo.heranca_polimorfismo.desafio_01;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class RetiradaLoja extends Pedido{

    // Construtor:
    public RetiradaLoja(Integer codPedido, LocalDate dataPedido, String nomeCliente, String enderCliente, Produto[] listaItens, Double frete){
        super(codPedido, dataPedido, nomeCliente, enderCliente, listaItens, frete);
    }
    
    // Polimorfismo:
    @Override
    public void calculoValorTotal(){
        Double valorTotal = 0.00;

        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.DOWN);

        if (this.listaItens.length >= 1){
            for (Produto produto : this.listaItens){
                valorTotal += produto.getPreco() * produto.getQuantidade();
            }
        }

        System.out.println("Valor total do pedido: "+ df.format(valorTotal) +" | Sem frete!");
    }

    // Método para exibir informações do pedido
    public void exibirInfoPedido(){
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.DOWN);
        
        System.out.println("- Código do pedido: "+ this.codPedido);
        System.out.println("- Data do pedido: "+ this.dataPedido);
        System.out.println("- Nome do cliente: "+ this.nomeCliente);
        System.out.println("- Endereço do cliente: "+ this.enderCliente);
        System.out.println("- Frete: R$0.00");
        System.out.println("_______________________________________");
        System.out.println("- Lista de itens: ");

        if (this.listaItens.length >= 1){
            for (Produto produto : this.listaItens){
                System.out.println("Nome: "+ produto.getNome() +" | Preço: "+ df.format(produto.getPreco()) +" | Quantidade: "+ produto.getQuantidade());
            }
        }
    }
}