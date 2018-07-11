package br.com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.entity.Aluno;
import br.com.entity.Curso;
import br.com.entity.Nota;

public class NotaMapper implements RowMapper<Nota>{

	@Override
	public Nota mapRow(ResultSet rs, int arg1) throws SQLException {
		Nota nota = new Nota();
		Aluno aluno = new Aluno();
		Curso curso = new Curso();
		nota.setId(rs.getInt("ID"));
		nota.setNota(rs.getDouble("NOTA"));
		aluno.setId(rs.getInt("ID_ALUNO"));
		curso.setId(rs.getInt("ID_CURSO"));
		nota.setAluno(aluno);
		nota.setCurso(curso);
		return nota;
	}

}
