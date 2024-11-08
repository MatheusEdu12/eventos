package org.example.eventos;

import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.example.Conexao;

public class CreateEventos {

    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        MongoCollection<Document> colecao = conexao.getBanco().getCollection("eventos");

        Document e1 = new Document();
        Document e2 = new Document();
        Document e3 = new Document();

        e1
                .append("nome", "Festival de Musica")
                .append("data", "2024-12-15")
                .append("hora", "18:00")
                .append("local", new Document()
                                .append("id", new ObjectId("672e3aca96187853c873d330"))
                                .append("nome", "Parque Central")                        
                        )
                .append("atracoes", List.of(
                        new Document()
                                .append("id", new ObjectId("672e3ad6d299bf0338d7b3b5"))
                                .append("nome", "Cantor Solo ABC"),
                        new Document()
                                .append("id", new ObjectId("672e3ad6d299bf0338d7b3b6"))
                                .append("nome", "Cantor de Funk")
                ));
        e2
                .append("nome", "Show de Rock")
                .append("data", "2024-12-20")
                .append("hora", "20:00")
                .append("local", new Document()
                                .append("id", new ObjectId("672e3acb96187853c873d331"))
                                .append("nome", "Arena Show")                        
                        )
                .append("atracoes", List.of(
                        new Document()
                                .append("id", new ObjectId("672e3ad6d299bf0338d7b3b3"))
                                .append("nome", "Banda XYZ"),
                        new Document()
                                .append("id", new ObjectId("672e3ad6d299bf0338d7b3b4"))
                                .append("nome", "Banda Metal")
                ));
        e3
                .append("nome", "Teatro")
                .append("data", "2024-12-25")
                .append("hora", "19:00")
                .append("local", new Document()
                                .append("id", new ObjectId("672e3acb96187853c873d332"))
                                .append("nome", "Teatro Aberto")                        
                        )
                .append("atracoes", List.of(
                        new Document()
                                .append("id", new ObjectId("672e3ad6d299bf0338d7b3b7"))
                                .append("nome", "Grupo de Teatro LMN"),
                        new Document()
                                .append("id", new ObjectId("672e3ad6d299bf0338d7b3b8"))
                                .append("nome", "Grupo de Teatro ABC")
                ));

        try {
            colecao.insertOne(e1);
            colecao.insertOne(e2);
            colecao.insertOne(e3);
            System.out.println("Eventos inseridos com sucesso!");
        } catch (MongoWriteException e) {
            e.printStackTrace();
        }
    }
}
