package br.com.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.entity.Escola;
import br.com.mapper.EscolaMapper;
import br.com.util.UtilDAO;

public class EscolaDAO extends UtilDAO<Escola>{

	@Override
	public List<Escola> listarTodos() throws Exception {
		List<Escola> escolas = new ArrayList<>();
		try {
			escolas = this.jdbcTemplate.query("SELECT * FROM ESCOLA", new EscolaMapper());
		} catch (Exception e) {
			throw e;
		}
		return escolas;
	}

	@Override
	public Escola buscar(int id) throws Exception {
		Escola escola = null;
		try {
			String query = "SELECT * FROM ESCOLA WHERE ID= ? ";
			escola = this.jdbcTemplate.queryForObject(query, new Integer[] { id }, new EscolaMapper());
		} catch (Exception e) {
			throw e;
		}
		return escola;
	}
}
