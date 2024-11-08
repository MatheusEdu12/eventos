package org.example.atracoes;

import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.example.Conexao;

public class CreateAtracoes {

    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        MongoCollection<Document> colecao = conexao.getBanco().getCollection("atracoes");

        Document a1 = new Document();
        Document a2 = new Document();
        Document a3 = new Document();
        Document a4 = new Document();
        Document a5 = new Document();
        Document a6 = new Document();

        a1
                .append("nome", "Banda XYZ")
                .append("tipo", "Banda");
        a2
                .append("nome", "Banda Metal")
                .append("tipo", "Banda");
        a3
                .append("nome", "Cantor Solo ABC")
                .append("tipo", "Artista Solo");
        a4
                .append("nome", "Cantor de Funk")
                .append("tipo", "Artista Solo");
        a5
                .append("nome", "Grupo de Teatro LMN")
                .append("tipo", "Teatro");
        a6
                .append("nome", "Grupo de Teatro ABC")
                .append("tipo", "Teatro");

        try {
            colecao.insertOne(a1);
            colecao.insertOne(a2);
            colecao.insertOne(a3);
            colecao.insertOne(a4);
            colecao.insertOne(a5);
            colecao.insertOne(a6);
            System.out.println("Atrações inseridas com sucesso!");
        } catch (MongoWriteException e) {
            e.printStackTrace();
        }
    }
}
