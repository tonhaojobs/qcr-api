package br.com.antonio.qcrapi.service;

import org.springframework.stereotype.Service;

import br.com.antonio.qcrapi.base.BaseService;
import br.com.antonio.qcrapi.entity.UsuarioEntity;
import br.com.antonio.qcrapi.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UsuarioService extends BaseService<UsuarioEntity, UsuarioRepository> {
	
	final String[] keys = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	
	public UsuarioEntity findByToken(String token){
		return this.getRepository().findByToken(token);
	}
	
	public UsuarioEntity findByEmail(String email){
		return this.getRepository().findByEmail(email);
	}
	
	public String createToken(){

		List<String> chars = new ArrayList<String>();
		
		Random random = new Random();
		String token = "";

		for (int i = 0; i < keys.length; i++) {
			chars.add(keys[i].toString());
		}

		for (int i = 0; i < 8; i++) {
			token += chars.get(random.nextInt(chars.size()));
		}
		
		if(token.matches("/^(.)\1+$/")/* CAPTURAR NUMEROS REPETIDOS */ || this.tokenExists(token)) {
			return this.createToken();
		} else {
			return token;
		}
	}
	
	private boolean tokenExists(String token){
		return (this.findByToken(token) != null);
	}
}