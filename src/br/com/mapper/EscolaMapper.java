package br.com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.entity.Escola;

public class EscolaMapper implements RowMapper<Escola>{

	@Override
	public Escola mapRow(ResultSet rs, int arg1) throws SQLException {
		Escola escola = new Escola();
		escola.setId(rs.getInt("ID"));
		escola.setNome(rs.getString("NOME"));
		return escola;
	}
}
