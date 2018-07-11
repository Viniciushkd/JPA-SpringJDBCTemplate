package br.com.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.entity.Curso;
import br.com.entity.Escola;

public class EscolaHelper {

	private EntityManager em;
	
	public EscolaHelper(EntityManager em) {
		this.em = em;
	}

	public String Salvar(Escola escola) {
		try {
			em.getTransaction().begin();
			em.persist(escola);
			em.getTransaction().commit();
			return "Escola cadastrada";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String adicionarCurso(int idEscola, Curso curso) {
		try {
			Escola escola = em.find(Escola.class, idEscola);
			curso.setEscola(escola);
			escola.getCursos().add(curso);
			em.getTransaction().begin();
			em.persist(escola);
			em.getTransaction().commit();
			return "Curso adicionado";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public List<Escola> listarEscola(){
		TypedQuery<Escola> query = em.createQuery("Select es from Escola es", Escola.class);
		return query.getResultList();
	}
	
	public List<Curso> listarCursos(int idEscola){
		TypedQuery<Curso> query = em.createQuery("Select c from Curso c Where c.escola.id = :idEscola", Curso.class);
		query.setParameter("id", idEscola);
		return query.getResultList();
	}
}
