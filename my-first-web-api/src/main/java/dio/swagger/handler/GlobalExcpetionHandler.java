package dio.swagger.handler;

import jakarta.annotation.Resource;

import org.springframework.cglib.proxy.UndeclaredThrowableException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class GlobalExcpetionHandler {
    @Resource
    private MessageSource messageSource; // capaz de pegar as msg de exceções

    private HttpHeaders headers(){ //cabeçalho da resposta
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private ResponseError responseError(String msg, HttpStatus statusCode){ // implementação para constituir a ResponseError 
        ResponseError responseError = new ResponseError();
        responseError.setStatus("error");
        responseError.setError(msg);
        responseError.setStatusCode(statusCode.value());
        return responseError;
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<Object> handleGeneral(Exception e, WebRequest request){
        if(e.getClass().isAssignableFrom(UndeclaredThrowableException.class)){
            UndeclaredThrowableException exception = (UndeclaredThrowableException) e;
            return handleBusinessException((BusinessException) exception.getUndeclaredThrowable(), request);
        }else{
            String message = messageSource.getMessage("error.server", new Object[]{e.getMessage()}, null);
            ResponseError error = responseError(message, HttpStatus.INTERNAL_SERVER_ERROR);
            return handleExceptionInternal(e, error, headers(), HttpStatus.INTERNAL_SERVER_ERROR, request);
        }
    }

    private ResponseEntity<Object> handleExceptionInternal(Exception e, ResponseError error, HttpHeaders headers,
            HttpStatus internalServerError, WebRequest request) {
        return null;
    }

    @ExceptionHandler({BusinessException.class})
    private ResponseEntity<Object> handleBusinessException(BusinessException e, WebRequest request){
        ResponseError error = responseError(e.getMessage(), HttpStatus.CONFLICT);
        return handleExceptionInternal(e, error, headers(), HttpStatus.CONFLICT, request);
    }

    private ResponseEntity<Object> handleExceptionInternal(BusinessException e, ResponseError error,
            HttpHeaders headers, HttpStatus conflict, WebRequest request) {
        return null;
    }

}
