package br.senai.sp.jandira;

import br.senai.sp.jandira.Repository.AlunoRepository;
import br.senai.sp.jandira.model.Aluno;
import br.senai.sp.jandira.ui.FrameCadastroAlunos;

public class App {

	public static void main(String[] args) {
		
		/*AlunoRepository turma = new AlunoRepository(5);
		
		Aluno a = new Aluno();
		a.setNome("Pedro");
		turma.gravar(a, 0);
		
		Aluno b = new Aluno();
		b.setNome("Ana");
		turma.gravar(b, 1);
		
		Aluno c = new Aluno();
		c.setNome("Luiza");
		turma.gravar(c, 2);
		
		Aluno d = new Aluno();
		d.setNome("Jorjinho");
		turma.gravar(d, 3);
		
		Aluno e = new Aluno();
		e.setNome("Carl Johnson");
		turma.gravar(e, 4);
		
		
		//Exibir os nomes dos alunos da turma
		
		for (Aluno alunoatual : turma.listarTodos()) {
			System.out.println(alunoatual.getNome());
			
			
		}
		*/
		
		
		

		FrameCadastroAlunos frame = new FrameCadastroAlunos();
		frame.setVisible(true);
		
	}
}
