package br.com.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.entity.Curso;
import br.com.mapper.CursoMapper;
import br.com.util.UtilDAO;

public class CursoDAO extends UtilDAO<Curso>{

	@Override
	public List<Curso> listarTodos() throws Exception {
		List<Curso> cursos = new ArrayList<>();
		try {
			cursos = this.jdbcTemplate.query("SELECT * FROM CURSO", new CursoMapper());
		} catch (Exception e) {
			throw e;
		}
		return cursos;
	}
	
	@Override
	public Curso buscar(int id) throws Exception {
		Curso curso = null;
		try {
			String query = "SELECT * FROM CURSO WHERE ID= ? ";
			curso = this.jdbcTemplate.queryForObject(query, new Integer[] { id }, new CursoMapper());
		} catch (Exception e) {
			throw e;
		}
		return curso;
	}
	
	public List<Curso> listarTodos(int id) throws Exception {
		List<Curso> cursos = new ArrayList<>();
		try {
			cursos = this.jdbcTemplate.query("SELECT * FROM CURSO WHERE ID_ESCOLA= ?", new Integer[] { id }, new CursoMapper());
		} catch (Exception e) {
			throw e;
		}
		return cursos;
	}
}
