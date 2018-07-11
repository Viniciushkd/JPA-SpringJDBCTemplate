package br.com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Aluno")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id", unique=true, nullable=false)
	private Integer id;
	@Column(name="nome", unique=false, nullable=false)
	private String nome;
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="alunos")
	private List<Curso> cursos = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="aluno") 
	private List<Nota> notas = new ArrayList<>();
//	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	public List<Nota> getNotas() {
		return notas;
	}
	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
	
	@Override
	public String toString() {
		return getNome();
	}
}
