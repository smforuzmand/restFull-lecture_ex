package se.mohsen.restfulllecture_ex.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class APIErrorsViolation extends APIError{


    private List<Violation> violationsList;

    public APIErrorsViolation(Integer statusCode, String statusText, String message, List<Violation> violationsList) {
        super(statusCode, statusText, message);
        this.violationsList = violationsList;
    }
}
