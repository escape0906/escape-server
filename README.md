1. 전체 조회

파라미터로 page, size 등을 입력할 수 있습니다. ex) /api/themes?page=3&size=10 

request
```http request
GET /api/themes
```

response
```json
{
  "content": [
    {
      "id": 1,
      "thumbnail": "https://www.keyescape.co.kr/file/theme_info/40_a.jpg",
      "title": "BACK TO THE SCENE+",
      "location": ""
    },
    {
      "id": 2,
      "thumbnail": "https://www.keyescape.co.kr/file/theme_info/38_a.jpg",
      "title": "머니머니패키지",
      "location": ""
    }
  ],
  "pageable": {
    "sort": {
      "empty": true,
      "sorted": false,
      "unsorted": true
    },
    "offset": 0,
    "pageSize": 2,
    "pageNumber": 0,
    "paged": true,
    "unpaged": false
  },
  "last": false,
  "totalPages": 300,
  "totalElements": 600,
  "size": 2,
  "number": 0,
  "sort": {
    "empty": true,
    "sorted": false,
    "unsorted": true
  },
  "first": true,
  "numberOfElements": 2,
  "empty": false
}
```

2. 개별 조회

request
```http request
GET /api/themes/{themeId}
```

response
```json
{
"id": 1,
"title": "BACK TO THE SCENE+",
"thumbnail": "https://www.keyescape.co.kr/file/theme_info/40_a.jpg",
"genre": " ",
"store": "키이스케이프",
"address": "",
"playTime": 65,
"recommendedPeople": "",
"maximumPeople": 0
}
```