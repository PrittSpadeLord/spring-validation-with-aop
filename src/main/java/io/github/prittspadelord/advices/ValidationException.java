package io.github.prittspadelord.advices;

import java.util.List;

public class ValidationException extends RuntimeException {

    private final List<String> errors;

    public ValidationException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }

    @Override
    public String getMessage() {

        StringBuilder builder = new StringBuilder();

        for(String error: errors) {
            builder.append("\n - ").append(error);
        }

        return super.getMessage() + " with errors: " + builder;
    }
}
