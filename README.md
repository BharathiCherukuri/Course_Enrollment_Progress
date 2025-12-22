A Spring Boot backend application that provides RESTful APIs to manage course enrollment and track user lesson progress.

Tech Stack:
  Java 17
  Spring Boot 3.x
  Maven
  Embedded Tomcat

How to Run the Project
  Prerequisites
    Java 17 or higher installed
    Maven installed
  Steps
  1. Clone the repository
  2. Navigate to the project folder
  3. Build the project
  4. Run the application
  5. The server will start at: "http://localhost:8080"

API Endpoints
  1. Enroll in a Course - POST /courses/{courseId}/enroll - Eg: http://localhost:8080/courses/101/enroll?userId=1
        Rule: A user can enroll only once in a course.
  2. Mark Lesson as Complete - POST /courses/{courseId}/lessons/{lessonId}/complete - Eg: http://localhost:8080/courses/101/lessons/5/complete?userId=1
        Rule: This operation is idempotent (calling it multiple times gives the same result).
  3. Get Course Progress - GET /users/{userId}/courses/{courseId}/progress - Eg: http://localhost:8080/users/1/courses/101/progress
        Returns: Total lessons, Completed lessons, Progress percentage
