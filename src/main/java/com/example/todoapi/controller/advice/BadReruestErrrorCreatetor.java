package com.example.todoapi.controller.advice;

import com.example.todo_api.model.BadRequestError;
import com.example.todo_api.model.InvalidParam;
import jakarta.validation.ConstraintViolationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.stream.Collectors;

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
        return new BadRequestError(); //TODO
    }
}
