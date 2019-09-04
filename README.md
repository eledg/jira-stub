# Jira Stub

An open source Jira stub for Jira Server.

## 1. Running locally

## 1.1 Prerequisites

The below is required to be installed for the Jira stub to run locally:

1. Java 8
2. Gradle `brew install gradle` with MacOS

## 1.2 Running development services locally

1. Build app and install dependencies with `gradle clean build`, or setup your IDE to do this for you
2. Run the `main/src/JiraStub.kt` class in your preferred IDE
3. This will run the API locally on port `8081`
