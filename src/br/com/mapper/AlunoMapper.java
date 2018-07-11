package br.com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.entity.Aluno;

public class AlunoMapper implements RowMapper<Aluno>{

	@Override
	public Aluno mapRow(ResultSet rs, int arg1) throws SQLException {
		Aluno aluno = new Aluno();
		aluno.setId(rs.getInt("ID"));
		aluno.setNome(rs.getString("NOME"));
		return aluno;
	}

}
