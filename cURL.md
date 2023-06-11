<h1 align ="center">Customers</h1>

Post

    curl --location 'http://localhost:8080/v1/customers' \
    --header 'Content-Type: application/json' \
    --data-raw '{
    "name" : "Francisco",
    "cpf" : "47912217125",
    "email" : "Francisco@gmail.com",
    "active" : true
    }'

Get/Id

   curl --location 'http://localhost:8080/v1/customers/1' \
    --data ''

Put/Id

    curl --location --request PUT 'http://localhost:8080/v1/customers/1' \
    --header 'Content-Type: application/json' \
    --data-raw '{
    "name" : "Robson Freitas",
    "cpf" : "47925117483",
    "email" : "rbsonfr@gmail.com",
    "active" : true
    }'

<h1 align ="center">Products</h1>

Post

    curl --location 'http://localhost:8080/v1/products' \
    --header 'Content-Type: application/json' \
    --header 'Authorization: Basic bWFyeToxMjM=' \
    --data '{
    "name" : "Shirt",
    "description" : "M cotton shirt",
    "price" : 58.90
    }'

Get/All

    curl --location 'http://localhost:8080/v1/products' \
    --header 'Authorization: Basic bWFyeToxMjM=' \
    --data ''

Get/Id

    curl --location 'http://localhost:8080/v1/products/1' \
    --header 'Authorization: Basic bWFyeToxMjM=' \
    --data ''

Put/Id

    curl --location --request PUT 'http://localhost:8080/v1/products/1' \
    --header 'Content-Type: application/json' \
    --header 'Authorization: Basic bWFyeToxMjM=' \
    --data '{
    "name" : "Mouse",
    "description" : "RGB mouse",
    "price" : 158.90
    }'

Delete/Id

    curl --location --request DELETE 'http://localhost:8080/v1/products/1' \
    --header 'Authorization: Basic bWFyeToxMjM=' \
    --data ''