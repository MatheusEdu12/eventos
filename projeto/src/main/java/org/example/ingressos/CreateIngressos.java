package org.example.ingressos;

import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.example.Conexao;

public class CreateIngressos {

    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        MongoCollection<Document> colecao = conexao.getBanco().getCollection("ingressos");

        Document i1 = new Document();
        Document i2 = new Document();
        Document i3 = new Document();

        i1
                .append("tipoIngresso", "Comum")
                .append("preco", 150.00)
                .append("evento", new Document()
                                .append("id", new ObjectId("672e3babac2438594aad93be"))
                                .append("nome", "Festival de Música")
                        
                        );
        i2
                .append("tipoIngresso", "Comum")
                .append("preco", 150.00)
                .append("evento", new Document()
                                .append("id", new ObjectId("672e3babac2438594aad93bf"))
                                .append("nome", "Show de Rock")
                        
                        );
        i3
                .append("tipoIngresso", "Comum")
                .append("preco", 100.00)
                .append("evento", new Document()
                                .append("id", new ObjectId("672e3babac2438594aad93c0"))
                                .append("nome", "Teatro")
                        
                        );

        try {
            colecao.insertOne(i1);
            colecao.insertOne(i2);
            colecao.insertOne(i3);
            System.out.println("Ingressos inseridos com sucesso!");
        } catch (MongoWriteException e) {
            e.printStackTrace();
        }
    }
}
