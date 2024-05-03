
<img src="minuRL/src/assets/Minurl_logo.png" width="200" height="200"/>


# MINU.RL 

A url shortener service created in spring boot 3 & Angular 17.


## Demo

[![IMAGE ALT TEXT HERE](minURL.gif)


## Features

**URL Validator:** URL Validator is implemented on the backend to validate that the url matches speicifed regex for standard URLs

**Unique input Hashing:** Every input is unique as its timestamp is added to the input and the whole input after the change is hashed using SHA256 thus results in a unique hashing everytime.

**Redirect View:** when shortened URLs are pasted they call a get controller which checks for original url, if it exists it checks for scheme and subdomain, based on them the url to be redirected to is adjusted.


## Run Front End Locally

Make sure you have nodejs installed.

Open your CMD (Command Prompt).

Clone the project

```bash
  git clone https://github.com/Oelassal/minu-URLShortener
```

Go to the project directory

```bash
  cd minu-URLShortener
```

Go to the front end directory

```bash
  cd minuRL
```


Install dependencies

```bash
  npm install
```

Start the server

```bash
  npm start
```


## Run Back End Locally

If you followed the first two steps in running front end locally then no need to git clone the application again, otherwise implement the first two commands in "Run Front End Locally".

Assuming you did, now run the application from "MinuApplication". and voila.

    
