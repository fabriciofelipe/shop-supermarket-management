package com.shop.supermarket.handlers;

import com.shop.supermarket.execeptions.InvalidParametersException;
import com.shop.supermarket.execeptions.PathNotFoundException;
import lombok.Data;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;

@Data
public class ThrowableTranslator {

    private final HttpStatus httpStatus;
    private final String message;

    private ThrowableTranslator(final Throwable throwable) {
        this.httpStatus = getStatus(throwable);
        this.message = throwable.getMessage();
    }

    private HttpStatus getStatus(final Throwable error) {
        if(error instanceof PathNotFoundException) {
            return HttpStatus.NOT_FOUND;
        } else if (error.getCause() instanceof InvalidParametersException){
                return HttpStatus.BAD_REQUEST;
        } else {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }


   public HttpStatus getHttpStatus(){
        return httpStatus;

    }

    public String getMessage() {
        return message;
    }

    static <T extends Throwable> Mono<ThrowableTranslator> translate(final Mono<T> throwable) {
        return throwable.flatMap(error -> Mono.just(new ThrowableTranslator(error)));
    }
}