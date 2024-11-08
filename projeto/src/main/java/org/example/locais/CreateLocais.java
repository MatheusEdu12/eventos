package org.example.locais;

import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.example.Conexao;

public class CreateLocais {

    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        MongoCollection<Document> colecao = conexao.getBanco().getCollection("locais");

        Document l1 = new Document();
        Document l2 = new Document();
        Document l3 = new Document();

        l1
                .append("nome", "Parque Central")
                .append("endereco", "Rua Principal, 1000, Centro");
        l2
                .append("nome", "Arena Show")
                .append("endereco", "Av. das Nações, 300, Zona Sul");
        l3
                .append("nome", "Teatro Aberto")
                .append("endereco", "Rua do Teatro, 50, Norte");

        try {
            colecao.insertOne(l1);
            colecao.insertOne(l2);
            colecao.insertOne(l3);
            System.out.println("Locais inseridos com sucesso!");
        } catch (MongoWriteException e) {
            e.printStackTrace();
        }
    }
}
