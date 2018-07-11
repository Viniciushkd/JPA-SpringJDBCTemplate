package br.com.bo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.dao.AlunoDAO;
import br.com.dao.CursoDAO;
import br.com.dao.EscolaDAO;
import br.com.dao.NotaDAO;
import br.com.entity.Aluno;
import br.com.entity.Curso;
import br.com.entity.Escola;
import br.com.entity.Nota;
import br.com.helper.CursoHelper;
import br.com.helper.EscolaHelper;
import br.com.helper.NotaHelper;
import br.com.interf.IEscolaProject;

public class EscolaProjectBO implements IEscolaProject{

	protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaJPA");
	protected EntityManager em = emf.createEntityManager();
	protected EscolaHelper Ehelper = new EscolaHelper(em);
	protected CursoHelper Chelper = new CursoHelper(em);
	protected NotaHelper Nhelper = new NotaHelper(em);

	protected ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
	protected EscolaDAO eDao = (EscolaDAO) context.getBean("EscolaDAO");
	protected CursoDAO cDao = (CursoDAO) context.getBean("CursoDAO");
	protected AlunoDAO aDao = (AlunoDAO) context.getBean("AlunoDAO");
	protected NotaDAO nDao = (NotaDAO) context.getBean("NotaDAO");
	
	public void cadastrarEscola(Escola escola) {
		System.out.println(Ehelper.Salvar(escola));
	}

	public void cadastrarCurso(Escola escola, Curso curso) {
		System.out.print(Ehelper.adicionarCurso(escola.getId(), curso));
	}

	public void cadastrarAluno(Curso curso, Aluno aluno) {
		System.out.println(Chelper.AdicionarAluno(curso.getId(), aluno));
	}

	public void cadastrarNota(Curso curso, Aluno aluno, Nota nota) {
		System.out.print(Nhelper.AdicionarNota(curso.getId(), aluno.getId(), nota));
	}

	public List<Escola> listarEscolas() {
		try {
			return eDao.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Escola buscaEscola(int idEscola) {
		try {
			return eDao.buscar(idEscola);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Curso> listarCursos() {
		try {
			return cDao.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Curso> listarCursos(int idEscola) {
		try {
			return cDao.listarTodos(idEscola);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Curso buscaCurso(int idCurso) {
		try {
			return cDao.buscar(idCurso);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Aluno> listarAlunos(int idCurso) {
		try {
			return aDao.listarTodos(idCurso);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Aluno> listarAlunos() {
		try {
			return aDao.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Aluno buscaAluno(int idAluno) {
		try {
			return aDao.buscar(idAluno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Nota> listarNotas() {
		try {
			return nDao.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Nota buscaNota(int idNota) {
		try {
			return nDao.buscar(idNota);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Nota buscarNota(int idCurso, int idAluno) {
		try {
			return nDao.buscarNota(idCurso, idAluno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
