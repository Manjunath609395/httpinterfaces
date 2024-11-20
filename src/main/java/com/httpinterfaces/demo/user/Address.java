package com.httpinterfaces.demo.user;

public record Address(
    String Street,
    String suite,
    String city,
    String zipcode,
    Geo geo) { }
