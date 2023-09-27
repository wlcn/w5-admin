# W5 admin DDD

DDD practice project. multiple modules by gradle

## target

1. User CRUD sample

## demo

- GET by id

```shell
curl --location 'http://localhost:8080/api/v1/user/1'
```

```json
{
  "id": "1",
  "phone": "123",
  "password": "123",
  "profile": {
    "name": "张三",
    "age": 18,
    "birthday": "2020-01-11T00:00:00"
  }
}
```

- DELETE by id

```shell
curl --location --request DELETE 'http://localhost:8080/api/v1/user/1'
```

```json
{
  "id": "1",
  "phone": "123",
  "password": "123",
  "profile": {
    "name": "张三",
    "age": 18,
    "birthday": "2020-01-11T00:00:00"
  }
}
```

- POST save

```shell
curl --location 'http://localhost:8080/api/v1/user' \
--header 'Content-Type: application/json' \
--data '{
    "phone": "123",
    "password": "123",
    "profile": {
        "name": "张三",
        "age": 18,
        "birthday": "2020-01-11T00:00:00"
    }
}'
```

```json
{
  "id": "1",
  "phone": "123",
  "password": "123",
  "profile": {
    "name": "张三",
    "age": 18,
    "birthday": "2020-01-11T00:00:00"
  }
}
```

- PUT update

```shell
curl --location --request PUT 'http://localhost:8080/api/v1/user' \
--header 'Content-Type: application/json' \
--data '{
    "id": "1",
    "phone": "123-u",
    "password": "123",
    "profile": {
        "name": "张三",
        "age": 18,
        "birthday": "2020-01-11T00:00:00"
    }
}'
```

```json
{
  "id": "1",
  "phone": "123-u",
  "password": "123",
  "profile": {
    "name": "张三",
    "age": 18,
    "birthday": "2020-01-11T00:00:00"
  }
}
```

- GET find list

```shell
curl --location 'http://localhost:8080/api/v1/user/find' \
--header 'Content-Type: application/json' \
--data '{
    "phone": "123",
    "profile": {
        "name": "张三",
        "age": 18
    }
}'
```

```json
[
  {
    "id": "1",
    "phone": "123",
    "password": "123",
    "profile": {
      "name": "张三",
      "age": 18,
      "birthday": "2020-01-11T00:00:00"
    }
  },
  {
    "id": "8",
    "phone": "123",
    "password": "123",
    "profile": {
      "name": "张三",
      "age": 18,
      "birthday": "2020-01-11T00:00:00"
    }
  }
]
```
