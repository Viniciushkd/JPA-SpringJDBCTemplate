
package br.com.app;

import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.com.bo.EscolaProjectBO;
import br.com.entity.Aluno;
import br.com.entity.Curso;
import br.com.entity.Escola;
import br.com.entity.Nota;
import br.com.interf.IEscolaProject;

public class App {

	static IEscolaProject epBO = new EscolaProjectBO();

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		while (true) {
			HashMap<String, Integer> hm = new HashMap<>();
			hm.put("Selecionar Escola", 1);
			hm.put("Cadastrar Escola", 2);
			Object[] EscolaOp = hm.keySet().toArray();

			String opcao = (String) JOptionPane.showInputDialog(null, "Opções", "Escola", JOptionPane.DEFAULT_OPTION, null,
					EscolaOp, null);

			if (opcao == null)
				break;

			switch (hm.get(opcao)) {
			case 1:
				Escola escolaSelecionada = (Escola) JOptionPane.showInputDialog(null, "Selecione a Escola", "Escola",
						JOptionPane.DEFAULT_OPTION, null, epBO.listarEscolas().toArray(), null);
				
				if(escolaSelecionada == null)
					break;
				
				System.out.println(
						"Escola [" + escolaSelecionada.getId() + " - " + escolaSelecionada.getNome() + "] selecionada");
				goCursos(escolaSelecionada);
				break;

			case 2:
				Escola escolaCadastro = new Escola();
				String nome = JOptionPane.showInputDialog("Nome da Escola");
				escolaCadastro.setNome(nome);

				epBO.cadastrarEscola(escolaCadastro);
				break;
			}
		}
	}

	private static void goCursos(Escola escola) {
		while (true) {
			HashMap<String, Integer> hm = new HashMap<>();
			hm.put("Selecionar Curso", 1);
			hm.put("Cadastrar Curso", 2);
			Object[] CursoOp = hm.keySet().toArray();

			String opcao = (String) JOptionPane.showInputDialog(null, "Opções", "Escola > Curso", JOptionPane.DEFAULT_OPTION, null,
					CursoOp, null);

			if (opcao == null)
				break;

			switch (hm.get(opcao)) {
			case 1:
				Curso cursoSelecionado = (Curso) JOptionPane.showInputDialog(null, "Selecione o Curso", "Escola: " + escola.getNome(),
						JOptionPane.DEFAULT_OPTION, null, epBO.listarCursos(escola.getId()).toArray(), null);
				
				if (cursoSelecionado == null) {
					JOptionPane.showMessageDialog(null, "Escola não possui nenhum curso", "Escola", JOptionPane.ERROR_MESSAGE);
					break;
				}
				
				System.out.println(
						"Curso [" + cursoSelecionado.getId() + " - " + cursoSelecionado.getNome() + "] selecionado");
				goAlunos(cursoSelecionado);
				break;

			case 2:
				Curso cursoCadastro = new Curso();
				String nome = JOptionPane.showInputDialog("Nome do Curso");
				cursoCadastro.setNome(nome);

				epBO.cadastrarCurso(escola, cursoCadastro);
				break;
			}

		}
	}

	private static void goAlunos(Curso curso) {
		while (true) {
			HashMap<String, Integer> hm = new HashMap<>();
			hm.put("Selecionar Aluno", 1);
			hm.put("Cadastrar Aluno", 2);
			Object[] AlunoOp = hm.keySet().toArray();

			String opcao = (String) JOptionPane.showInputDialog(null, "Opções", "... > Curso > Aluno", JOptionPane.DEFAULT_OPTION, null,
					AlunoOp, null);

			if (opcao == null)
				break;

			switch (hm.get(opcao)) {
			case 1:
				Aluno alunoSelecionado = (Aluno) JOptionPane.showInputDialog(null, "Selecione Aluno", "Curso: " + curso.getNome(),
						JOptionPane.DEFAULT_OPTION, null, epBO.listarAlunos(curso.getId()).toArray(), null);

				if (alunoSelecionado == null) {
					JOptionPane.showMessageDialog(null, "Curso não possui nenhum aluno", "Curso", JOptionPane.ERROR_MESSAGE);
					break;
				}
				
				System.out.println("Aluno [" + alunoSelecionado.getId() + " - " + alunoSelecionado.getNome() + "] selecionado");
				goNota(alunoSelecionado, curso);
				break;

			case 2:
				Aluno alunoCadastro = new Aluno();
				String nome = JOptionPane.showInputDialog("Nome do Aluno");
				alunoCadastro.setNome(nome);

				epBO.cadastrarAluno(curso, alunoCadastro);
				break;
			}
		}
	}

	private static void goNota(Aluno alunoSelecionado, Curso curso) {
		while (true) {
			HashMap<String, Integer> hm = new HashMap<>();
			hm.put("Exibir Nota", 1);
			hm.put("Cadastrar Nota", 2);
			Object[] AlunoOp = hm.keySet().toArray();

			String opcao = (String) JOptionPane.showInputDialog(null, "Opções", "... > Curso > Aluno", JOptionPane.DEFAULT_OPTION, null,
					AlunoOp, null);

			switch (hm.get(opcao)) {
			case 1:
				JOptionPane.showMessageDialog(null, "Curso: " + curso.getNome() + "\nAluno: " + alunoSelecionado.getNome() + "\nNota: " + epBO.buscarNota(curso.getId(), alunoSelecionado.getId()), "Ultima nota", JOptionPane.INFORMATION_MESSAGE);
				break;

			case 2:
				Nota notaCadastro = new Nota();
				String nota = JOptionPane.showInputDialog("Nota do Aluno " + alunoSelecionado.getNome());
				notaCadastro.setNota(Double.parseDouble(nota.replaceAll(",", ".")));

				epBO.cadastrarNota(curso, alunoSelecionado, notaCadastro);
				break;
			}
		}
	}
}
