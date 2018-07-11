package br.com.util;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class UtilDAO<T> {

	protected JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public abstract List<T> listarTodos() throws Exception;

	public abstract T buscar(int id) throws Exception;
}
