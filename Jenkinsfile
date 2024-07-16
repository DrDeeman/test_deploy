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
                sh 'npm install'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing deploy project...'
                sh 'npm test'
            }
        }
    }
}