package br.com.antonio.qcrapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.antonio.qcrapi.base.BaseController;
import br.com.antonio.qcrapi.entity.UsuarioEntity;
import br.com.antonio.qcrapi.service.UsuarioService;


@RestController
@RequestMapping(path = "/api/usuario", produces = { MediaType.APPLICATION_JSON_VALUE })
public class UsuarioController extends BaseController<UsuarioEntity, UsuarioService> {

    @SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);

    @SuppressWarnings("rawtypes")
	@GetMapping("/token/{token}")
    public ResponseEntity findByToken(@PathVariable String token) {
		
		UsuarioEntity usuario = getService().findByToken(token);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/email/{email}")
    public ResponseEntity findByEmail(@PathVariable String email) {
		
		UsuarioEntity usuario = getService().findByEmail(email);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

}
