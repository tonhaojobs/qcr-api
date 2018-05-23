package br.com.antonio.qcrapi.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USUARIO",  schema = "ZETA")
public class UsuarioEntity implements Serializable {
	
	private static final long serialVersionUID = 2481416119433177197L;

	@Id
	@Column(name = "ID_USUARIO", unique = true, nullable = false, precision = 10, scale = 0)
	@GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sequence", sequenceName = "USUARIO_SEQ", allocationSize = 1)
	private Long id;
	
	@Column(name = "TOKEN", nullable = false, unique = true, precision = 30)
	private String token;
	
	@Column(name = "EMAIL", nullable = false, unique = true, precision = 255)
	private String email;
	
	@Column(name = "SENHA", nullable = false, precision = 255)
	private String senha;
	
	@Column(name = "PRIMEIRO_NOME", nullable = false, precision = 255)
	private String primeiroNome;
	
	@Column(name = "ULTIMO_NOME", precision = 255)
	private String ultimoNome;
	
	@Column(name = "USUARIO_ATIVO", nullable = false)
	private Boolean usuarioAtivo;
	
	@Column(name = "DT_CRIACAO_USUARIO", nullable = false)
	private LocalDateTime dtCriacao;


}