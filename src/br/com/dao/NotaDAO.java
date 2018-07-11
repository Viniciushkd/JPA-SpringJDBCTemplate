package br.com.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.entity.Nota;
import br.com.mapper.NotaMapper;
import br.com.util.UtilDAO;

public class NotaDAO extends UtilDAO<Nota> {

	@Override
	public List<Nota> listarTodos() throws Exception {
		List<Nota> notas = new ArrayList<>();
		try {
			notas = this.jdbcTemplate.query("SELECT * FROM NOTA", new NotaMapper());
		} catch (Exception e) {
			throw e;
		}
		return notas;
	}

	@Override
	public Nota buscar(int id) throws Exception {
		Nota nota = null;
		try {
			String query = "SELECT * FROM NOTA WHERE ID= ? ";
			nota = this.jdbcTemplate.queryForObject(query, new Integer[] { id }, new NotaMapper());
		} catch (Exception e) {
			throw e;
		}
		return nota;
	}

	public List<Nota> listarTodosAluno(int id) throws Exception {
		List<Nota> notas = new ArrayList<>();
		try {
			String query = "SELECT * FROM NOTA WHERE ID_ALUNO= ? ";
			notas = this.jdbcTemplate.query(query, new Integer[] { id }, new NotaMapper());
		} catch (Exception e) {
			throw e;
		}
		return notas;
	}
	
	public Nota buscarNota(int id_curso, int id_aluno) throws Exception {
		Nota nota = null;
		try {
			String query = "SELECT * FROM NOTA WHERE ID_CURSO= ? AND ID_ALUNO= ? ORDER BY ID DESC LIMIT 1";
			nota = this.jdbcTemplate.queryForObject(query, new Integer[] { id_curso, id_aluno }, new NotaMapper());
		} catch (Exception e) {
			throw e;
		}
		return nota;
	}
	
}
