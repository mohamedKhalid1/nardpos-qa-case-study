# NardPOS QA Automation Case Study

This repository contains an automated QA testing framework designed to validate critical workflows of the **NardPOS SaaS POS platform**.

The project includes **API testing**, **UI automation**, and **CI/CD integration**.

---

# Project Structure

```
nardpos-qa-case-study
│
├── api-tests
│   ├── postman_collection.json
│   ├── environment.json
│
├── ui-tests
│   ├── src
│   │   ├── tests
│   │   │   └── CreateSaleTest.java
│   │   ├── pages
│   │   │   ├── LoginPage.java
│   │   │   ├── SalesPage.java
│   │   │   └── ProductsPage.java
│
├── reports
│
├── .github/workflows
│   └── qa-tests.yml
│
├── README.md
└── .env.example
```

---

# Tech Stack

API Testing

* Postman
* Newman (CLI runner)

UI Automation

* Selenium WebDriver
* Java
* TestNG / JUnit

Reporting

* Newman HTML report
* Selenium test reports

CI/CD

* GitHub Actions

---

# API Testing

API tests were implemented using **Postman collections** and executed via **Newman**.

## Endpoints Tested

| Endpoint       | Method | Description                               |
| -------------- | ------ | ----------------------------------------- |
| /auth/login    | POST   | Authenticate user and return access token |
| /products      | GET    | Retrieve product list                     |
| /sales         | POST   | Create a new sale                         |
| /sales/:id     | GET    | Retrieve specific sale                    |
| /sales/archive | GET    | Retrieve archived sales                   |

---

# Test Scenarios

### Authentication

* Login with valid credentials
* Login with invalid credentials
* Validate response token

### Products

* Fetch product list with valid token
* Fetch products without authentication

### Sales

* Create sale with valid payload
* Create sale with invalid payload
* Validate response schema and status codes

---

# UI Automation

UI automation is implemented using **Selenium WebDriver with Java**.

## Automated Flow

1. Login to POS system
2. Create a sale with two products
3. Verify the sale appears in **Sales History**

Page Object Model (POM) is used for better maintainability.

---

# Running API Tests

Install Newman globally:

```
npm install -g newman
```

Run the collection:

```
newman run api-tests/postman_collection.json \
-e api-tests/environment.json
```

Generate HTML report:

```
newman run api-tests/postman_collection.json \
-e api-tests/environment.json \
-r cli,html
```

---

# Running UI Tests

Navigate to UI test folder:

```
cd ui-tests
```

Run tests:

```
mvn test
```

---

# CI/CD Integration

The project includes a **GitHub Actions pipeline** that runs automated tests on every push to:

* main
* develop

Pipeline steps include:

1. Checkout repository
2. Install dependencies
3. Run API tests using Newman
4. Run Selenium UI tests
5. Upload test reports

---

# Design Decisions

* Postman used for quick and flexible API test creation.
* Newman used for CLI execution and CI integration.
* Selenium Java implemented using Page Object Model.
* Environment files used for configurable API URLs and tokens.

---

# Improvements

* Add Allure reporting for richer test visualization
* Implement parallel UI test execution
* Add performance validation for APIs
* Extend UI automation coverage

---

# Author

QA Automation Engineer Candidate
NardPOS Case Study
