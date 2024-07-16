#!/usr/bin/env groovy

pipeline {

    agent {
        docker {
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