package br.com.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.entity.Aluno;
import br.com.mapper.AlunoMapper;
import br.com.util.UtilDAO;

public class AlunoDAO extends UtilDAO<Aluno> {

	@Override
	public List<Aluno> listarTodos() throws Exception {
		List<Aluno> alunos = new ArrayList<>();
		try {
			alunos = this.jdbcTemplate.query("SELECT * FROM ALUNO", new AlunoMapper());
		} catch (Exception e) {
			throw e;
		}
		return alunos;
	}

	@Override
	public Aluno buscar(int id) throws Exception {
		Aluno aluno = null;
		try {
			String query = "SELECT * FROM ALUNO WHERE ID= ? ";
			aluno = this.jdbcTemplate.queryForObject(query, new Integer[] { id }, new AlunoMapper());
		} catch (Exception e) {
			throw e;
		}
		return aluno;
	}
	
	public List<Aluno> listarTodos(int id) throws Exception {
		List<Aluno> alunos = new ArrayList<>();
		try {
			alunos = this.jdbcTemplate.query("SELECT A.* FROM ALUNO A INNER JOIN CURSO_ALUNO CA ON A.ID = CA.ID_ALUNO WHERE CA.ID_CURSO= ?", new Integer[] { id }, new AlunoMapper());
		} catch (Exception e) {
			throw e;
		}
		return alunos;
	}
}
