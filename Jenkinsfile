pipeline {
    agent any //{ docker { image 'maven:3.9.9-eclipse-temurin-21-alpine' } }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn -B -DskipTests clean install'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'mvn test'
            }
        }
        stage('Code Analysis') {
            steps {
                echo 'Analysing source code..'
                sh 'mvn pmd:pmd'
            }
        }
    }
}