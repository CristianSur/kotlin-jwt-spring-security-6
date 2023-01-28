#Sample of spring security using JWT | kotlin-jwt-spring-security-6
<h2>POST</h2>
    
    localhost:9090/api/auth/register
    {
        "email": "some.user@gmail.com",
        "username": "anonym",
        "password": "123456"
    }
    
<h2>POST</h2>

    localhost:9090/auth/authenticate
    {
        "username": "anonym",
        "password": "123456"
    }
    
<h3>RESPONSE</h3>

    {
        "token": "eyJhbG..."
    }


After registration we get a JWT Token response and have to put it in header.

Authorization | Bearer <token>
