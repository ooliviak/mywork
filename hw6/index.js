const express = require("express")
const app = express()
 
// Ddoski: I need this so I can access it from my front-end webpage :) (https://expressjs.com/en/resources/middleware/cors.html)
var cors = require('cors')

// Ddoski: I use this to parse the data from requests! So if someone sends a post request with JSON, I can read it :D
const bodyParser = require("body-parser");
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

app.use(cors())

// Ddoski: In the future, I'll store this in a database, but for now, I'll keep it in an array.
let flashcards = []

// Ddoski: I defined an endpoint here, so when someone sends a POST request to http://localhost:3000/new with some JSON data, 
// I add this to my flashcards array.
app.post("/new", (req, res) => {
    flashcards.push(req.body)
    res.sendStatus(200)
})

// Ddoski: Could you make an endpoint here so that if someone makes a GET request to http://localhost:3000/cards, 
// I send the flashcards array as a response?
// QUESTION 1.
app.get("/cards", (req, res) => {
    res.send(flashcards)
})

app.get("/card/:id", (req, res) => {
    if (req.params.id >= flashcards.length) {
        res.send("Card not created.")
    } else {
        // Ddoski: I want to send back a JSON of the flashcard at the index [req.params.id]! (Hint: res.json() might be helpful here)
        // QUESTION 2.
        res.json(flashcards[req.params.id])
    }
})

// Ddoski: This gets a random integer!
function randomInteger(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }

// Ddoski: We use the previous function to randomize what card we send back!
app.get("/random", (req, res) => {
    randomNum = randomInteger(0, flashcards.length - 1)
    res.json(flashcards[randomNum])
})

// Ddoski: I want to define an endpoint here "/delete/SOMETHING", but SOMETHING is an id that I can input,
// so when we do "/delete/2", it deletes the card at index 2 in the flashcards array.
// Hint: Check above for how we did it for a previous endpoint.
// Hint: You might use flashcards.splice(req.params.id, 1) here to delete the card.
// QUESTION 3.
app.get("/delete/:id", (req, res) => {
    // First, check if req.params.id is more than or equal to the length of the flashcards array.
    // If it is, that means the card the user wants to delete does not exist, so send "Card does not exist".
    if (req.params.id >= flashcards.length) {
        res.send("Card does not exist.")
    } else {
        // Now, delete the card, and send the flashcards array back as a response.
        flashcards.splice(req.params.id, 1)
        res.send(flashcards)
    }
})

// OPTIONAL TASK 1: Basic (Bad) Authentication

app.get("/sign-in-with-basic-security", (req, res) => {
    let authToken = req.headers.auth;

    if (signedIn) {
        /* OPTIONAL TASK 1 */
        
        // Use res.send() to tell the user they're already signed in

        /* YOUR CODE HERE */
    }

    if (!authToken) {
        res.send("Auth token was not passed.")
    } else {
        let authTokenArr = authToken.toString().split(":")


        /* OPTIONAL TASK 2 */

        // Set enteredUsername equal to the first element in authTokenArr and enteredPassword equal to the second element.

        let enteredUsername = ""; /* YOUR CODE HERE (Change the value of enteredUsername) */
        let enteredPassword = ""; /* YOUR CODE HERE (Change the value of enteredPassword) */

        
        if (enteredUsername == username && enteredPassword == password) {
            signedIn = true
            res.send("You've been signed in successfully!")
        } else {
            res.send("Auth token was not correct.")
        }
    }
})

// This is the same as our "/cards" get method, but this time with basic security.
app.get("/cards-with-basic-security", (req, res) => {

    /* OPTIONAL TASK 3 */

    // If the user is signed in, send back the flashcards using res.send(), otherwise use res.send() to tell the user they're not signed in. 
    /* HINT: you need an if/else block */

    /* YOUR CODE HERE */
})

// This is a method to sign out using basic security.
app.get("/sign-out-with-basic-security", (req, res) => {
    try {
        signedIn = false
        if (!signedIn) {
            res.send("You've been successfully signed out!")
        } else {
            res.send("An error occured.")
        }
    } catch(e) {
        res.send("An error occured.")
    }
})

// OPTIONAL TASK 2: Secure Authentication Using JWT Tokens

// Secure sign in using JWT tokens
app.get("/sign-in-secure", (req, res) => {

    // Create variables enteredUsername and enteredPassword equal to username and password in req.headers

    let enteredUsername = req.headers.username; /* Set the value equal to username in our headers */
    let enteredPassword = req.headers.password; /* Set the value equal to password in our headers */

    /* This is a user object that will be related to your JWT token */
    const user = { username: enteredUsername, password: enteredPassword }

    /* This creates a new JWT token for your user, using our ACCESS_TOKEN_SECRET for security. */
    const accessToken = jwt.sign(user, process.env.ACCESS_TOKEN_SECRET)

    /* We send back our accessToken for further use */
    res.json({ accessToken })
})

/* authenticateToken() is a function for validating that you are signed in using good security */
function authenticateToken(req, res, next) {
    let auth = req.headers.authorization;

    // auth header was not passed
    if (!auth) {
        // Sends back a 401 error: Unauthorized
        res.sendStatus(401)
    }
    
    /* OPTIONAL TASK 4 */
    
    /* auth consits of the string "Bearer (TOKEN)", where each string is seperated by a space.
    Use .split() and array indexing (e.g. arr[0], arr[1]) to assign authToken to the value of TOKEN */

    let authToken = ""; /* YOUR CODE HERE (Change the value of authToken) */

    // auth token doesn't exist
    if (!authToken) {
        // Sends back a 401 error: Unauthorized
        res.sendStatus(401)
    }

    /* JWT verify() will verify that the token that you passed is indeed a real user */

    jwt.verify(authToken, process.env.ACCESS_TOKEN_SECRET, (error, user) => {
        if (error) {
            return res.send("Authorization token was incorrect.")
        } else {
            req.user = user
            next()
        }
    })
}

/* This function will return the flashcards using the security of the authenticateToken() function */
app.get("/cards-with-good-security", authenticateToken, (req, res) => {
        res.send(flashcards)
})

// BONUS! Implement any endpoint you think you'd want in an API for a flashcard/Quizlet-style website!
/* YOUR CODE HERE */

app.listen(3000, () => {
    // Ddoski: This function starts my server so that it's listening out for requests.
    // Let's do console.log something like "Listening on port 3000" so we know our app started.
    
    // QUESTION 4.
    console.log("Listening on port 3000")
})
