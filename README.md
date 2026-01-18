# CS320 Software Automation and Testing Portfolio

This project was developed as part of **CS320: Software Automation and Testing** at Southern New Hampshire University. The primary goal was to create three specific features, Contact, Appointment, and Task services, along with their corresponding object classes, and to implement rigorous unit testing to ensure functionality and reliability.

This repository showcases the full project, demonstrating proficiency in software testing, automation, and quality assurance.

## Project Details

- **Build System:** Gradle with Kotlin
- **Run Environment:** Windows 11 with IntelliJ IDEA 2025.3.1
- **Code Coverage:** 100% (98% in branching logic)

## How to Run

This is an IntelliJ IDEA project. You can run the tests using the IDE's built-in test runner or via the command line:

```bash
gradlew test
```

## Reflections

To ensure that code is both functional (verification) and meets customer requirements (validation), I rely heavily on a comprehensive testing strategy. While this specific project was scoped to Unit Testing, ensuring a software product is truly secure and functional requires a layered approach including integration testing, system testing, and acceptance testing. By achieving near 100% code coverage, I ensured that every logical path was executed and verified, which significantly reduces the surface area for logic errors and potential security vulnerabilities caused by unhandled edge cases.
How do I interpret user needs and incorporate them into a program?

User needs and expectations must be clearly determined through user research and conducted studies. When developing software for a client, it is crucial to clarify that the software is being built for a specific user base and must tie directly to their needs. By refining and creating a Software Requirement Specification (SRS), we ensure that the client, development team, and testing team are aligned. This alignment is a core requirement in methodologies like Agile. From the SRS, the testing team can derive specific test cases to ensure that the software not only "works" but adheres strictly to what the user actually needs.
How do I approach designing software?

My approach to software design is heavily influenced by Test-Driven Development (TDD). Taking this course has reinforced my belief in TDD by demonstrating the "safety net" it provides. Writing tests first forces you to design the interface and behavior of your code before implementing the logic, resulting in cleaner, more modular designs. Although thorough testing can be time-consuming upfront, it is necessary to ensure the software is implemented correctly. Furthermore, these tests act as regression tests, allowing me to add new features or refactor code in the future without the fear of breaking existing functionality.

**NOTE: This project does not contain a main class or function. It was created purely for the purpose of testing and quality assurance demonstration.**
