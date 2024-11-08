package org.example.clientes;

import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.example.Conexao;

public class CreateClientes {

    public static void main(String[] args) {

        Conexao conexao = new Conexao();
        MongoCollection<Document> colecao = conexao.getBanco().getCollection("clientes");

        Document c1 = new Document();
        Document c2 = new Document();
        Document c3 = new Document();

        c1
                .append("nome", "Matheus Eduardo")
                .append("cpf", "121.584.648-55")
                .append("telefone", "(82)9829-8465")
                .append("ingressos", List.of(
                        new Document()
                                .append("id", new ObjectId("672e3c2547e3f06fe49a08b5")) // ID correto do evento 'Show de Rock'
                                .append("nome", "Show de Rock")
                ));
        c2
                .append("nome", "Luccas Eduardo")
                .append("cpf", "122.700.396-15")
                .append("telefone", "(82)9857-3398")
                .append("ingressos", List.of(
                        new Document()
                                .append("id", new ObjectId("672e3c2547e3f06fe49a08b5")) // ID correto do evento 'Show de Rock'
                                .append("nome", "Show de Rock"),
                        new Document()
                                .append("id", new ObjectId("672e3c2547e3f06fe49a08b4")) // ID correto do evento 'Festival de Música'
                                .append("nome", "Festival de Música")
                ));
        c3
                .append("nome", "Eduardo Wanderley")
                .append("cpf", "122.698.684-10")
                .append("telefone", "(82)99110-3509")
                .append("ingressos", List.of(
                        new Document()
                                .append("id", new ObjectId("672e3c2547e3f06fe49a08b5")) // ID correto do evento 'Show de Rock'
                                .append("nome", "Show de Rock"),
                        new Document()
                                .append("id", new ObjectId("672e3c2547e3f06fe49a08b4")) // ID correto do evento 'Festival de Música'
                                .append("nome", "Festival de Musica"),
                        new Document()
                                .append("id", new ObjectId("672e3c2547e3f06fe49a08b6")) // ID correto do evento 'Teatro'
                                .append("nome", "Teatro")
                ));

        try {
            colecao.insertOne(c1);
            colecao.insertOne(c2);
            colecao.insertOne(c3);
            System.out.println("Clientes inseridos com sucesso!");
        } catch (MongoWriteException e) {
            e.printStackTrace();
        }
    }
}
