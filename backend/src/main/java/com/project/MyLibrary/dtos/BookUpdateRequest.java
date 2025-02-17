package com.project.MyLibrary.dtos;

public record BookUpdateRequest(String title, String author, Double price, Double rating, Integer year, String bookLink, Boolean isRead) {


}
