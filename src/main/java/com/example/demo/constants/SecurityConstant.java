package com.example.demo.constants;

public class SecurityConstant {
    public static final long EXPIRATION_TIME=432_000_000;//5 days
    public static final String TOKEN_HEADER = "Bearer ";
    public static final String JWT_TOKEN_HEADER = "Jwt-Token";
    public static final String TOKEN_CANNOT_BE_VERIFIED ="Token cannot be verified";
    public static final String GET_ARRAYS= "Get arrays";
    public static final String ADMINISTRATION = "User Management Portal";
    public static final String AUTHORIZATION = "Jwt";
    public static final String AUTHORITIES = "authorities";
    public static final String FORBIDDEN_MESSAGE = "You need to in to access this page";
    public static final String ACCESS_DENIED_MESSAGE="You dont have permission to access this page";
    public static final String OPTIONS_HTTP_METHOD="OPTIONS";
    public static final String[] PUBLIC_URLS={"/user/login","/user/register","/user/resetpassword","/user/image/**"};
}




















