BOOK API:

1. create book

POST /books

```shell script
curl -d '{"author":"Carpenter","title":"A day in the woods"}' -H 'Content-Type: application/json' http://localhost:8080/books
```

2. list books

GET /books

```shell script
curl http://localhost:8080/books
```

3. update a book

PUT /books/:id

```shell script
curl -X PUT -d '{"author":"Mrs. Carpenter","title":"A day in the woods"}' -H 'Content-Type: application/json' http://localhost:8080/books/2

```

4. delete a book

DELETE /books/:id

```shell script
curl -X DELETE http://localhost:8080/books/2
```