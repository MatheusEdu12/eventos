package com.eventos;

public class Conexao {
    
    private MongoClient cliente;
    private MongoDatabase banco;
    
    public Conexao(){
        cliente = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        banco = cliente.getDatabase("eventosdb");
        
        System.out.println("Conexão realizada com sucesso!");
    }

    public MongoDatabase getBanco() {
        return banco;
    }        
    
    public static void main(String[] args) {
        Conexao conn = new Conexao();
    }
