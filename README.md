# kotlin-jwt-spring-security-6
Sample of spring security using JWT 

POST
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
