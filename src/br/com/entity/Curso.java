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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Curso")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id", unique=true, nullable=false)
	private Integer id;
	@Column(name="nome", unique=false, nullable=false)
	private String nome;
	@ManyToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinTable(name="Curso_Aluno", joinColumns={@JoinColumn(name="id_curso", nullable=false, updatable=false)},
		inverseJoinColumns={@JoinColumn(name="id_aluno", nullable=false, updatable=false)})
	private List<Aluno> alunos;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_escola")
	private Escola escola;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="curso")
	private List<Nota> notas = new ArrayList<>();
	
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
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public Escola getEscola() {
		return escola;
	}
	public void setEscola(Escola escola) {
		this.escola = escola;
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
