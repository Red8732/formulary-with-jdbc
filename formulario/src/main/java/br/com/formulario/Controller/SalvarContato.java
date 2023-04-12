package br.com.formulario.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.formulario.Login.Contato;
import br.com.formulario.jdbc.dao.ContatoDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

	@WebServlet("/contato-salvo")
public class SalvarContato extends HttpServlet {
		
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("/formulario/");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		//	pegando	os parâmetros do request:
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String email = req.getParameter("email");
		String dataEmTexto = req.getParameter("dataNascimento");
		Calendar dataNascimento = null;

		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy")
					.parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
			
		} catch (ParseException e) {
			out.println("Erro de conversao da data.");
			return; //para a execução do método
		}
		
		// montando um objeto contato e adicionando ele no banco de dados:
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		
		ContatoDao db = new ContatoDao();
		db.adiciona(contato);
		
		// imprimindo o contato adicionado:
		out.println("<html>");
		out.println("<body>");
		out.println("O contato de " + contato.getNome() + " foi adicionado com sucesso!");								
		out.println("</body>");
		out.println("</html>");
	}
}
