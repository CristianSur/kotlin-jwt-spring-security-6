# Sample of spring security using JWT | kotlin-jwt-spring-security-6

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

<h2></h2>

After registration/authentication we get a JWT Token in response and have to put it in header to access secured endpoints.

<p>Authorization | Bearer <token></p>
    
![image](https://user-images.githubusercontent.com/90960365/215284250-8f7ec7d4-a28d-4eb9-af6c-9bc577310a27.png)

<h3>GET</h3>

    localhost:9090/api/home //Header is present

<h3>RESPONSE</h3>

    Hello, welcome to secured endpoint.
    
    
