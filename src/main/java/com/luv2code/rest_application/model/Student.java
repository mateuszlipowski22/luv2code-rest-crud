package com.luv2code.rest_application.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class Student {

    String firstName;
    String lastName;
    String country;
    String favoriteLanguage;
    List<String> favoriteSystems;

}
