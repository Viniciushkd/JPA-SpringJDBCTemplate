package br.com.helper;

import javax.persistence.EntityManager;

import br.com.entity.Aluno;
import br.com.entity.Curso;

public class CursoHelper {

	private EntityManager em;
	
	public CursoHelper(EntityManager em) {
		this.em = em;
	}
	
	public String SalvarCurso(Curso curso) {
		try {
			em.getTransaction().begin();
			em.persist(curso);
			em.getTransaction().commit();
			return "Curso cadastrada";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String AdicionarAluno(int idCurso, Aluno aluno) {
		try {
			Curso curso = em.find(Curso.class, idCurso);
			aluno.getCursos().add(curso);
			curso.getAlunos().add(aluno);
			em.getTransaction().begin();
			em.persist(curso);
			em.getTransaction().commit();
			return "Aluno adicionado";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
