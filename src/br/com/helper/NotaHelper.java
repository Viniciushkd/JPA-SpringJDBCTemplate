package br.com.helper;

import javax.persistence.EntityManager;

import br.com.entity.Aluno;
import br.com.entity.Curso;
import br.com.entity.Nota;

public class NotaHelper {
	
	private EntityManager em;
	
	public NotaHelper(EntityManager em) {
		this.em = em;
	}
	
	public String AdicionarNota(int idCurso, int idAluno, Nota nota) {
		try {
			Curso curso = em.find(Curso.class, idCurso);
			Aluno aluno = em.find(Aluno.class, idAluno);
			nota.setAluno(aluno);
			nota.setCurso(curso);
			aluno.getNotas().add(nota);
			curso.getNotas().add(nota);
			em.getTransaction().begin();
			em.persist(curso);
			em.getTransaction().commit();
			return "Nota cadastrada";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
