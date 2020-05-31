**`This is a spring boot Maven application based on H2 In memory data base. So run it as a spring boot application.`**

1. Schema File is 'schema.sql' which will create or drop schema when ever application restart.
2. Created two entities Library and Book.
3. Assumption:
    1st we need to create a virtual library using api #1 and after that we add book inside that library using api #2. Library have name as unique constraint and book has isbn as unique constraint.
4. H2 in-memory database can be access using this link once application start: username and password is:  gpac
   
   _localhost:9092/h2-console/_

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