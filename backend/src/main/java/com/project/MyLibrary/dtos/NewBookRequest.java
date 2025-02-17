package com.project.MyLibrary.dtos;

import jakarta.validation.constraints.NotEmpty;

public record NewBookRequest(@NotEmpty(message = "Title must not be null or empty") String title,
                             @NotEmpty(message = "Author must not be null or empty") String author,
                             @NotEmpty(message = "Price must not be null or empty") Double price,
                             @NotEmpty(message = "Rating must not be null or empty") Double rating,
                             @NotEmpty(message = "Year must not be null or empty") Integer year,
                             String bookLink,
                             @NotEmpty(message = "getIsRead must not be null or empty") Boolean isRead) {
}
