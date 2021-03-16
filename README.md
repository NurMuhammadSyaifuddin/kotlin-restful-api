# API Spec

## Authentication

All Api must use this authentication

Request :
- Header :
    - X-Api-Key : "your secret API Key"

## Create Product

Request :

- Method : POST
- Endpoint : `/api/products`
- Header :
    - content-type : application/json
    - accept : application/json
- body :

```json
{
  "id": "String, unique",
  "name": "String",
  "price": "Long",
  "quantitiy": "Integer"
}
```

Response :

```json
{
  "code": "number",
  "status": "String",
  "data": {
    "id": "String, unique",
    "name": "String",
    "price": "Long",
    "quantitiy": "Integer",
    "createdAt": "Date",
    "updatedAt": "Date"
  }
}
```

## Get Product

Request :

- Method : GET
- Endpoint : `/api/products/{id_product}`
- Header :
    - accept : application/json

Response :

```json
{
  "code": "number",
  "status": "String",
  "data": {
    "id": "String, unique",
    "name": "String",
    "price": "Long",
    "quantitiy": "Integer",
    "createdAt": "Date",
    "updatedAt": "Date"
  }
}
```

## Update Product

Request :

- Method : PUT
- Endpoint : `/api/products/{id_product}`
- Header :
    - content-type : application/json
    - accept : application/json
- body :

```json
{
  "name": "String",
  "price": "Long",
  "quantitiy": "Integer"
}
```

Response :

```json
{
  "code": "number",
  "status": "String",
  "data": {
    "id": "String, unique",
    "name": "String",
    "price": "Long",
    "quantitiy": "Integer",
    "createdAt": "Date",
    "updatedAt": "Date"
  }
}
```

## List Product

Request :

- Method : GET
- Endpoint : `/api/products`
- Header :
    - accept : application/json
- Query param :
    - size : number
    - page : number

Response :

```json
{
  "code": "number",
  "status": "String",
  "data": [
    {
      "id": "String, unique",
      "name": "String",
      "price": "Long",
      "quantitiy": "Integer",
      "createdAt": "Date",
      "updatedAt": "Date"
    },
    {
      "id": "String, unique",
      "name": "String",
      "price": "Long",
      "quantitiy": "Integer",
      "createdAt": "Date",
      "updatedAt": "Date"
    }
  ]
}
```

## Delete Product

Request :

- Method : DELETE
- Endpoint : `/api/products/{id_product}`
- Header :
    - accept : application/json

Response :

```json
{
  "code": "number",
  "status": "String"
}
```

