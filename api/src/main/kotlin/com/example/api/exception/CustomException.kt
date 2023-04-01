package com.example.api.exception

class CustomException(val customErrorCode: CustomErrorCode) : RuntimeException() {
}