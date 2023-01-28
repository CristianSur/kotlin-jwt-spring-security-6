# kotlin-jwt-spring-security-6
<h1>Sample of spring security using JWT </h1>

    <h2>POST</h2>
localhost:9090/api/auth/register
{
    "email": "some.user@gmail.com",
    "username": "anonym",
    "password": "123456"
}

POST
localhost:8080/auth/authenticate
{
    "username": "anonym",
    "password": "123456"
}


After registration we get a JWT Token response and have to put it in header.

Authorization | Bearer <token>
