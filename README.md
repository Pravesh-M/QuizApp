# QuizApp

Welcome to the QuizApp Spring Boot project. This application is designed to manage and conduct quizzes by providing endpoints to create, read, update, and delete questions, categorize them, create quizzes with random questions, and allow users to submit quizzes.

## Getting Started

1. **Clone the repository**
   ```shell
   git clone https://github.com/PraveshM/QuizApp.git
   ```
   Alternatively, you can download the project as a ZIP file and extract it.
   
2. **Import Project**
   
   Open your favorite IDE (e.g Intellij IDEA, STS, VSCode) and import the project as a Maven project.

3. **Run the Application**

   Run the Spring Boot application using your IDE.The application will start on http://localhost:8085

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
