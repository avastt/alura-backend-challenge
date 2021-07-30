package br.com.backend.alurachallenge.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroDeValidacaoHandler {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeFormularioDto> handle(MethodArgumentNotValidException exception) {

		List<ErroDeFormularioDto> listaErroDeFormularioDto = new ArrayList<>();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

		for (FieldError fieldError : fieldErrors) {

			String mensagem = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());

			ErroDeFormularioDto erroDeFormularioDto = new ErroDeFormularioDto(fieldError.getField(), mensagem);
			listaErroDeFormularioDto.add(erroDeFormularioDto);

		}

		return listaErroDeFormularioDto;
	}
}



/*CLASSE SERÁ INVOCADA QUANDO HOUVER ERROR NO CONTROLLER ATRAVÉS DA CLASSE MethodArgumentNotValidException
 * por função tratar as mensagens de erro padrão
 * */