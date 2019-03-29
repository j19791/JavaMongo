import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Principal {

	public static void main(String[] args) {
		MongoClient cliente = new MongoClient(); // conectar ao mongo
		MongoDatabase bancoDeDados = cliente.getDatabase("test");// selecionar o banco de dados do qual queremos
																	// realizar as consultas
		MongoCollection<Document> alunos = bancoDeDados.getCollection("alunos");// selecionar uma coleção específica
		Document aluno = alunos.find().first();// selecionaremos o primeiro documento dessa coleção
		// System.out.println(aluno);

		// Document novoAluno = new Document("nome", "Joao").append("data_nascimento",
		// new Date(2003, 10, 10)).append("curso", new Document("nome",
		// "Historia")).append("notas", Arrays.asList(10, 9, 8)).append("habilidades",
		// Arrays.asList(new Document().append("nome", "Ingles ").append("nível",
		// "Básico"), new Document().append("nome", "Espanhol").append("nível",
		// "Básico")));

		// System.out.println(novoAluno);

		// alunos.insertOne(novoAluno);

		// alunos.updateOne(Filters.eq("nome", "Joao"), new Document("$set", new
		// Document("nome", "Joao Pedro")));

		alunos.deleteOne(Filters.eq("nome", "Joao Silva")); // remove um registro com nome igual a Joao Silva

		cliente.close();// fechar conexão com bd
	}

}
