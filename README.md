# NardPOS QA Automation Case Study

This repository contains an automated QA testing framework created to validate core workflows of the **NardPOS POS SaaS platform**.

The project includes:

* API automation using Postman and Newman
* UI automation using Selenium WebDriver with Java
* Automated test reports
* Ready structure for CI/CD integration

---

# Project Structure

```
nardpos-qa-case-study
│
├── api-tests
│   ├── NardPOS.postman_collection.json
│   └── NardPOS.postman_environment.json
│
├── ui-tests
│   └── selenium-tests (Java)
│
├── reports
│
├── README.md
└── .env.example
```

---

# Installation

## 1. Clone the repository

```
git clone https://github.com/mohamedKhalid1/nardpos-qa-case-study.git
```

```
cd nardpos-qa-case-study
```

---

## 2. Install Newman (for API tests)

Install Newman globally:

```
npm install -g newman
```

Verify installation:

```
newman -v
```

---

## 3. Install Java & Maven (for UI tests)

Ensure the following are installed:

* Java 17
* Maven
* Chrome Browser
* ChromeDriver

Verify installations:

```
java -version
mvn -version
```

---

# Running API Tests

Run API tests using Newman:

```
newman run api-tests/NardPOS.postman_collection.json \
-e api-tests/NardPOS.postman_environment.json
```

Generate HTML report:

```
newman run api-tests/NardPOS.postman_collection.json \
-e api-tests/NardPOS.postman_environment.json \
-r cli,html
```

Reports will be generated in the **reports/** directory.

---

# Running UI Tests

Navigate to the Selenium tests directory:

```
cd ui-tests
```

Run tests using Maven:

```
mvn test
```

The automated UI test performs the following flow:

1. Login to the POS system
2. Create a sale with two products
3. Verify the sale appears in Sales History

---

# Example Command to Execute Tests

API Tests:

```
newman run api-tests/NardPOS.postman_collection.json -e api-tests/NardPOS.postman_environment.json
```

UI Tests:

```
mvn test
```

---

# Design Decisions

The project was designed with the following principles:

Modular Structure
API tests and UI tests are separated into independent folders for easier maintenance and scalability.

Environment Configuration
Environment variables are used to store configuration such as base URLs and credentials.

Reusable Test Data
Postman environment variables allow reuse of tokens and generated IDs across requests.

Page Object Model (UI Tests)
Selenium tests follow the Page Object Model to separate UI locators and test logic.

Automation Ready
The project structure allows easy integration with CI/CD tools such as GitHub Actions.

---

# Author

Mohamed Khalid
QA Automation Engineer Candidate
NardPOS QA Case Study
