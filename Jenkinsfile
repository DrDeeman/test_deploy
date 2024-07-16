#!/usr/bin/env groovy

pipeline {

    agent {
        any {
            image 'node'
            args '-u root'
        }
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building deploy project...'
                bat 'npm install'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing deploy project...'
                bat 'npm test'
            }
        }
    }
}