package java_poo.heranca_polimorfismo.desafio_01;

public class Cliente {
    // Propriedades:
    private String nome;
    private String endereco;

    // Construtor:
    public Cliente(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
    }

    //Métodos setters and getters:
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public String getNome(){
        return this.nome;
    }
    public String getEndereco(){
        return this.endereco;
    }
}