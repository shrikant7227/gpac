`This is a spring boot Maven application based on H2 In memory data base. So runt it as a spring boot application.`

1. Define Schema in 'schema.sql' which will create or drop schema.
2. Created two entities object Library and Book.
3. Assumption:
    A Book could not be added without the library department entry but a library department can be added without any book.
4. H2 in-memory database can be access after application start:
   
   localhost:9092/h2-console/

5. Application running on port: 9092
   
**_API Details_**
1. Create Library API: **[POST Request]**
_http://localhost:9092/library/create_

Json Request:  {
                 "name" : "SCIENCE",
                 "city" : "Mumbai"
               }

2 .  Create Book API: **[POST Request]**
_http://localhost:9092/book/create_       
                      
Json Request: {
                "publicationName" : "Shrikant-Pub",
                "title" : "Environmental Studies",
                "authorName" : "Shrikant Kumar",
                "isbn" : 202,
                "libraryDept" : "SCIENCE"
              }

3 . List Book API: **[GET Request]**
_http://localhost:9092/book/all_         

4  . List Library API: **[GET Request]**
http://localhost:9092/library/all

5 . List Book By Library: **[GET Request]**
http://localhost:9092/book/library/<<library_name>>