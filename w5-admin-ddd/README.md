# W5 admin DDD

DDD practice project. multiple modules by gradle

## target

1. User CRUD sample

## demo

- find by id

```shell
$ curl http://localhost:8080/api/v1/user/1
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

- save

```shell
$ curl -H "Content-Type:application/json" -X POST -d '{"id":"1","phone":"123","password":"123","profile":{"name":"张三","age":18,"birthday":"2020-01-11T00:00:00"}}' http://localhost:8080/api/v1/user
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
