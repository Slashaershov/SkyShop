package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.exceptions.NoSuchProductException;
import org.skypro.skyshop.model.exceptions.ShopError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
public class ShopControllerAdvice {

  @ExceptionHandler(NoSuchProductException.class)
  public ResponseEntity<ShopError> noSuchProductExceptionHandler(NoSuchProductException e) {
//    ShopError error = new ShopError("404", ex.getMessage());
//    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    return ResponseEntity.badRequest().body(new ShopError("404", e.getMessage()));
  }
}
