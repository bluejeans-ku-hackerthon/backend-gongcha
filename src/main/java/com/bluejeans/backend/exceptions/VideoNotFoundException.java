package com.bluejeans.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "A video does not exists")
public class VideoNotFoundException extends RuntimeException {
}
