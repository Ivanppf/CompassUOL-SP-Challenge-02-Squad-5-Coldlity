<h1 align ="center">Customers</h1>

Post

    curl --location 'http://localhost:8080/v1/customers' \
    --header 'Content-Type: application/json' \
    --header 'Authorization: Basic bWFyeToxMjM=' \
    --data-raw '{
    "name" : "Margarida",
    "cpf" : "479.151.654-83",
    "email" : "margarida@gmail.com",
    "active" : true
    }'

Get/Id

    curl --location --request GET 'http://localhost:8080/v1/customers/4' \
    --header 'Content-Type: application/json' \
    --header 'Authorization: Basic bWFyeToxMjM=' \
    --data-raw '{
    "name" : "Margarida",
    "cpf" : "479.151.654-83",
    "email" : "margarida@gmail.com",
    "active" : true
    }'

Put/Id

    curl --location --request PUT 'http://localhost:8080/v1/customers/4' \
    --header 'Content-Type: application/json' \
    --header 'Authorization: Basic bWFyeToxMjM=' \
    --data-raw '{
    "name" : "Margarida Ferreira",
    "cpf" : "479.151.654-83",
    "email" : "margarida@gmail.com",
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