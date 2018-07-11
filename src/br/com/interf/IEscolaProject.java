package br.com.interf;

import java.util.List;

import br.com.entity.Aluno;
import br.com.entity.Curso;
import br.com.entity.Escola;
import br.com.entity.Nota;

public interface IEscolaProject {

	void cadastrarEscola(Escola escola);

	void cadastrarCurso(Escola escola, Curso curso);

	void cadastrarAluno(Curso curso, Aluno aluno);

	void cadastrarNota(Curso curso, Aluno aluno, Nota nota);

	List<Escola> listarEscolas();
	
	Escola buscaEscola(int idEscola);
	
	List<Curso> listarCursos();
	
	List<Curso> listarCursos(int idEscola);
	
	Curso buscaCurso(int idCurso);
	
	List<Aluno> listarAlunos();
	
	List<Aluno> listarAlunos(int idCurso);
	
	Aluno buscaAluno(int idAluno);
	
	List<Nota> listarNotas();
	
	Nota buscaNota(int idNota);
	
	Nota buscarNota(int id_curso, int id_aluno);
}
