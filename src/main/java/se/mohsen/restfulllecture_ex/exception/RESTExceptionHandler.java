package se.mohsen.restfulllecture_ex.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RESTExceptionHandler extends ResponseEntityExceptionHandler {


//    what kind of exceptions we want to handle


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> illegalArgumentException(IllegalArgumentException ex) {
        APIError apiError = new APIError(
                HttpStatus.BAD_REQUEST.value(),//400
                HttpStatus.BAD_REQUEST.name(),//BAD_REQUEST
                ex.getMessage()//some Messagee from where exception was thrown
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> resourceFoundException(ResourceNotFoundException ex) {

        return ResponseEntity.status(400).body(new APIError(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name(),
                ex.getMessage()
        ));


    }


    @ExceptionHandler(ResourceDuplicateException.class)
    public ResponseEntity<Object> resourceDuplicateException(ResourceDuplicateException ex) {

        return ResponseEntity.status(400).body(new APIError(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name(),
                ex.getMessage()
        ));


    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> globalExceptionHandler(Exception ex) {

        return ResponseEntity.status(500).body(new APIError(
                500,
                HttpStatus.INTERNAL_SERVER_ERROR.name()
                ));


    }
}
