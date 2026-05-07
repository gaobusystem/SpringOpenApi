package com.example.todoapi.controller.advice;

import com.example.todo_api.model.BadRequestError;
import com.example.todo_api.model.InvalidParam;
import jakarta.validation.ConstraintViolationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.lang.model.element.ElementKind;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class BadReruestErrrorCreatetor {

    public static BadRequestError form(MethodArgumentNotValidException ex) {
        var invalidParamList = createInvalidParamList(ex);
        var error = new BadRequestError();
        error.setInvalidParams(invalidParamList);
        return error;
    }
    private static List<InvalidParam> createInvalidParamList(MethodArgumentNotValidException ex){
        return ex.getFieldErrors()
                .stream()
                .map(fieldError -> createInvalidParam(fieldError))
                .collect(Collectors.toList());
    }

    private static InvalidParam createInvalidParam(FieldError fieldError){
        var invalidParam = new InvalidParam();
        invalidParam.setName(fieldError.getField());
        invalidParam.setReason(fieldError.getDefaultMessage());
        return invalidParam;
    }

    public static BadRequestError form(ConstraintViolationException ex) {
        var invalidParamList = ex.getConstraintViolations()
                .stream()
                .map(violation -> {
                        var parameterOpt= StreamSupport.stream(violation.getPropertyPath().spliterator(),false)
                                .filter(node -> node.getKind().equals(ElementKind.PARAMETER))
                                .findFirst();
                        var invalidParam = new InvalidParam();
                    parameterOpt.ifPresent(p -> invalidParam.setName(p.getName()));
                    invalidParam.setReason(violation.getMessage());

                    return invalidParam;
                })
                .collect(Collectors.toList());
            var error = new BadRequestError();
            error.setInvalidParams(invalidParamList);

        return error;
    }
}
