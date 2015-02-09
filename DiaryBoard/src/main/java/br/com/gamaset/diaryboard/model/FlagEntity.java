package br.com.gamaset.diaryboard.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "BANDEIRAS")
public class FlagEntity implements Serializable{

	private static final long serialVersionUID = -8863600219740303519L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "BAND_CD_ID_PK")
	private Long id;
	
	@Column(name = "BAND_DS_COMPETICAO")
	private String nomeCompeticao;

	@Column(name = "BAND_DS_IMAGEM")
	private String nomeImagem;
	
	@Column(name = "BAND_DS_URLIMAGEM")
	private String urlImagem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompeticao() {
		return nomeCompeticao;
	}

	public void setNomeCompeticao(String nomeCompeticao) {
		this.nomeCompeticao = nomeCompeticao;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}
}
