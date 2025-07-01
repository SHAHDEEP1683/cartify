package com.ecom.cartify.service;

import org.openapitools.model.AuthResponseDTO;
import org.openapitools.model.LoginForm;

public interface RegistrationService {

     AuthResponseDTO doAuthenticate (LoginForm loginForm);
}
