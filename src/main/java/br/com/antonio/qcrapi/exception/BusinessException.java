package br.com.antonio.qcrapi.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -5741573036223234183L;

	public BusinessException(String message) {
        super(message);
    }
}
