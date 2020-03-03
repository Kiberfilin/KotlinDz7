# KotlinDz7
## Homework 7 CRUD
### API reference
- GET /api/v1/posts - список всех постов
- GET /api/v1/posts/{id} - получить пост с конкретным id
- POST /api/v1/posts/create - создать новый пост
- PATCH /api/v1/posts/{id}/update - отредактировать пост
- DELETE /api/v1/posts/{id} - удалить пост
- POST /api/v1/posts/{id}/likes - поставить лайк посту с конкретным id
- DELETE /api/v1/posts/{id}/likes - убрать лайк с поста с конкретным id
- POST /api/v1/posts/repost - сделать репост поста, пересылаемого JSONом
- POST /api/v1/posts/{id}/share - шаринг поста с конкретным id
* На Heroku залито
* heroku redeploy
