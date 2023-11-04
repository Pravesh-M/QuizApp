# QuizApp

Welcome to the QuizApp Spring Boot project. This application is designed to manage and conduct quizzes by providing endpoints to create, read, update, and delete questions, categorize them, create quizzes with random questions, and allow users to submit quizzes.

## Getting Started

1. Clone the repository:
   ```shell
   git clone https://github.com/PraveshM/QuizApp.git
   cd QuizApp
   ```
   
2. Import the application:
Import the application in IDE(e.g. IntelliJ IDEA, STS, VSCode).

3. Run the application:
Locate main class of the project then right click and run. By default, the application will run on `http://localhost:8085`. You can change the configuration in the `application.properties` file.

## Endpoints

The QuizApp project provides the following endpoints:

### Question Endpoints

- `GET /question/all`: Get a list of all questions.
- `GET /questions/{questionId}`: Get a question by ID.
- `GET /questions/category/{category}`: Get questions by category.
- `POST /question`: Create a new question.
- `PUT /question/{questionId}`: Update an existing question.
- `DELETE /questions/{questionId}`: Delete a question by ID.

### Quiz Endpoints

- `GET /quiz/{quizId}`: Get a quiz by ID.
- `POST /quiz/{quizName}/{category}/{noOfQuestions}`: Create a new quiz with quiz name & number of questions.
- `POST /quizzes/submit/{quizId}`: Submit a quiz by ID.

## Usage

To interact with the QuizApp, you can use tools like [Postman](https://www.postman.com/)

Please refer to the [Endpoints](#endpoints) section for details on how to use each endpoint.
