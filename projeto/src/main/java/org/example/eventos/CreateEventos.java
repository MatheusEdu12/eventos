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
                                .append("id", new ObjectId("672e1c24a7e83448356b6e99"))
                                .append("nome", "Parque Central")                        
                        )
                .append("atracoes", List.of(
                        new Document()
                                .append("id", new ObjectId("672e1c4ab903e27b392665dc"))
                                .append("nome", "Cantor Solo ABC"),
                        new Document()
                                .append("id", new ObjectId("672e1c4ab903e27b392665dd"))
                                .append("nome", "Cantor de Funk")
                ));
        e2
                .append("nome", "Show de Rock")
                .append("data", "2024-12-20")
                .append("hora", "20:00")
                .append("local", new Document()
                                .append("id", new ObjectId("672e1c24a7e83448356b6e9a"))
                                .append("nome", "Arena Show")                        
                        )
                .append("atracoes", List.of(
                        new Document()
                                .append("id", new ObjectId("672e1c4ab903e27b392665da"))
                                .append("nome", "Banda XYZ"),
                        new Document()
                                .append("id", new ObjectId("672e1c4ab903e27b392665db"))
                                .append("nome", "Banda Metal")
                ));
        e3
                .append("nome", "Teatro")
                .append("data", "2024-12-25")
                .append("hora", "19:00")
                .append("local", new Document()
                                .append("id", new ObjectId("672e1c24a7e83448356b6e9b"))
                                .append("nome", "Teatro Aberto")                        
                        )
                .append("atracoes", List.of(
                        new Document()
                                .append("id", new ObjectId("672e1c4ab903e27b392665de"))
                                .append("nome", "Grupo de Teatro LMN"),
                        new Document()
                                .append("id", new ObjectId("672e1c4ab903e27b392665df"))
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
