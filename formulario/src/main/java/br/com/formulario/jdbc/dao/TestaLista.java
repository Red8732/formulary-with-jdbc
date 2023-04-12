package br.com.formulario.jdbc.dao;

import java.util.Calendar;
import java.util.List;

import br.com.formulario.Login.Contato;

public class TestaLista {
	
	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.getLista();
		
		Contato alterar = new Contato();
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(1980, 0, 1);
		
		alterar.setId(4L);
		alterar.setNome("Teste Alterado");
		alterar.setEmail("teste2@hotmail.com");
		alterar.setEndereco("Testes Internos");
		alterar.setDataNascimento(dataNascimento);
		
		// dao.altera(alterar); -> altera o contato no banco de dados a partir do objeto contato
		// dao.remove(alterar); -> remove o contato
		
		for(Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Data de Nascimento: " + contato.getDataNascimento().getTime() + '\n');
		}
	}
}
