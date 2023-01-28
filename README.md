# Sample of spring security using JWT | kotlin-jwt-spring-security-6
### DB: PostgreSQL | Flyway migrations

## POST
    localhost:9090/api/auth/register
    {
        "email": "some.user@gmail.com",
        "username": "anonym",
        "password": "123456"
    }

## POST
    localhost:9090/auth/authenticate
    {
        "username": "anonym",
        "password": "123456"
    }

### RESPONSE
    {
        "token": "eyJhbG..."
    }


After registration/authentication we get a <b>JWT Token</b> in response and have to put it in header to access secured endpoints.

### <b>Authorization | Bearer <token> </b>
    
![image](https://user-images.githubusercontent.com/90960365/215284250-8f7ec7d4-a28d-4eb9-af6c-9bc577310a27.png)

## GET

    localhost:9090/api/home //Header is present

#### RESPONSE

    Hello, welcome to secured endpoint.
    
    
