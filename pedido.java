package java_poo.heranca_polimorfismo.desafio_01;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class Pedido {
    // Propriedades da classe:
    protected Integer codPedido;
    protected LocalDate dataPedido;
    protected String nomeCliente;
    protected String enderCliente;
    protected Produto[] listaItens;
    protected Double frete;
    
    // Construtor:
    public Pedido(Integer codPedido, LocalDate dataPedido, String nomeCliente, String enderCliente, Produto[] listaItens, Double frete){
        this.codPedido = codPedido;
        this.dataPedido = dataPedido;
        this.nomeCliente = nomeCliente;
        this.enderCliente = enderCliente;
        this.listaItens = listaItens;
        this.frete = frete;
    }
    
    // Métodos setters and getters:
    public void setCodPedido(Integer codPedido){
        this.codPedido = codPedido;
    }
    public void setDataPedido(LocalDate dataPedido){
        this.dataPedido = dataPedido;
    }
    public void setNomeCliente(String nomeCliente){
        this.nomeCliente = nomeCliente;
    }
    public void setEnderCliente(String enderCliente){
        this.enderCliente = enderCliente;
    }
    public void setItens(Produto[] listaItens){
        this.listaItens = listaItens;
    }
    public void setFrete(Double frete){
        this.frete = frete;
    }
    
    public Integer getCodPedido(){
        return this.codPedido;
    }
    public LocalDate getDataPedido(){
        return this.dataPedido;
    }
    public String getNomeCliente(){
        return this.nomeCliente;
    }
    public String getEnderCliente(){
        return this.enderCliente;
    }
    public Produto[] getItens(){
        return this.listaItens;
    }
    public Double getFrete(){
        return this.frete;
    }
    
    // Método de calculo de valor total:
    public void calculoValorTotal(){
        Double valorTotal = 0.00;

        if (this.listaItens.length >= 1){
            for (Produto produto : this.listaItens){
                valorTotal += produto.getPreco() * produto.getQuantidade();
            }
        }

        valorTotal += getFrete();

        System.out.println("Valor total do pedido: "+ valorTotal);
    }
    
    // Método para exibir informações do pedido:
    public void exibirInfoPedido(){
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.DOWN);
        
        System.out.println("- Código do pedido: "+ this.codPedido);
        System.out.println("- Data do pedido: "+ this.dataPedido);
        System.out.println("- Nome do cliente: "+ this.nomeCliente);
        System.out.println("- Endereço do cliente: "+ this.enderCliente);
        System.out.println("- Frete: "+ df.format(this.frete));
        System.out.println("_______________________________________");
        System.out.println("- Lista de itens: ");

        if (this.listaItens.length >= 1){
            for (Produto produto : this.listaItens){
                System.out.println("Nome: "+ produto.getNome() +" | Preço: "+ df.format(produto.getPreco()) +" | Quantidade: "+ produto.getQuantidade());
            }
        }
    }
}