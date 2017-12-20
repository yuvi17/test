# Instructions to run :

Run the jar inside the target folder
Ensure java is installed


This project has several APIs that can be used to access it.



# To Add a book

Url: /addBook
method: POST
sample request body :
```
{
	"title" : "Harry Potter and the Order of Phoenix",
	"author" : "J.K. Rowling",
	"description": "The fifth installment of J.K. Rowling's magical harry potter universe."
}
```

# To get List of all Boooks

Url: /getAllBooks
method: GET
response :

```
[
    {

	"title": "Harry Potter",
	"author": "J.K. Rowling",
	"description": null,
	"status": "Free",
	"addedTimeStamp": "Wed Dec 20 22:34:34 IST 2017",
	"id": "8570b22caa6c40d6ab305206e293def3"
   }
]
```


# To Search a Book
url: /searchBook/{param}/{value}

Accepted Params : 
1. title
2. author
3. id

value = title/author/id of user to be searched. Matches partial title/author(not ids), is case sensitive


# To Add a User

Url: /addUser
Method :  POST
sample request body
```
{
	"name" : "Yuvraj Jaiswal",
	"email" : "kumaryuvraj118@gmail.com",
	"password" : "yourpasswordhere"

}
```
## Will not let a user be added whose email has already been regsitered

# To Search a User
Url: /searchUser/{param}/{value}

Accepted Params : 
1. name
2. id
3. email

value = name/id of user to be searched. Matches partial names(not ids), is case sensitive

response :

{

    "user": {
        "name": "Yuvraj Jaiswal",
        "userId": "113d2c8461214052830162136c4e4ca2",
        "email": "kumaryuvraj118@gmail.com",
        "password": "yourpasswordhere",
        "borrowedCount": 0
    },
    "message": "User Found",
    "status": 200
}

# To Borrow a Book

url: /borrow
Method : POST
Sample Request Body :

{

	"userId" : "113d2c8461214052830162136c4e4ca2",
	"bookId" : "8570b22caa6c40d6ab305206e293def3"
}

## UserId and bookID to be taken from the response of above requests

## Will return with appropriate response if the book is already borrowed

## Will return with appropriate response if the user's book borrow limit has exceeded

# Responses : 
### Issued Successfully
{

    "message": "Issued to you",
    "status": 201
}
### Already in Circulation
{

    "message": "Book has already been issued",
    "status": 201
}
### Limit Exceeded
```
{
    "message": "You've exceeded the borrow limit",
    "status": 201
}
```


# To Return a Book

url: /back
Method : POST
Sample Request Body :

```
{
	"userId" : "113d2c8461214052830162136c4e4ca2",
	"bookId" : "8570b22caa6c40d6ab305206e293def3"
}
```

## UserId and bookID to be taken from the response of above requests


