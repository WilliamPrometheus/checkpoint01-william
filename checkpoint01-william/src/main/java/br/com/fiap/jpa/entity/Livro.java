package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_livro")
@SequenceGenerator(name = "livro", sequenceName = "SQ_TB_LIVRO", allocationSize = 1)
public class Livro implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Livro() {
		this.ativo = true;
		this.dataCadastro = LocalDateTime.now();
		this.dataAtualizacao = LocalDateTime.now();
	}
	
	public Livro(String titulo, String autor, String edicao, LocalDate anoPublicacao) {
		this();
		this.titulo = titulo;
		this.autor = autor;
		this.edicao = edicao;
		this.anoPublicacao = anoPublicacao;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livro")
	private Long id;
	
	@Column(name = "titulo", length = 50, nullable = false, unique = true)
	private String titulo;
	
	@Column(name = "autor", length = 30, nullable = false)
	private String autor;
	
	@Column(name = "edicao", length = 15, nullable = false)
	private String edicao; 
	
	@Column(name = "anoPublicacao")
	private LocalDate anoPublicacao;
	
	@Column(name = "st_ativo")
	private Boolean ativo;
	
	@Column(name = "dt_cadastro")
	private LocalDateTime dataCadastro;
	
	@Column(name = "dt_atualizacao")
	private LocalDateTime dataAtualizacao;
	


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public LocalDate getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(LocalDate anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public String toString() {
		
		return "\nTitulo: " + this.getTitulo()
			+ "\nAutor: " + this.getAutor() 
			+ "\nAno Publicado: " + this.getAnoPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

}
