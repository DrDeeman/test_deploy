pipeline {
    agent any
    stages {
          stage('Fetch Code') {
                    steps {
                        git "git@github.com:DrDeeman/test_deploy.git"
                    }
                }

        stage('Code Analysis') {
                    environment {
                        scannerHome = tool 'test_sonar'
                    }
                    steps {
                        script {
                            withSonarQubeEnv('Sonar') {
                                sh "${scannerHome}/bin/sonar-scanner \
                                    -Dsonar.projectKey=<project-key> \
                                    -Dsonar.projectName=<project-name> \
                                    -Dsonar.projectVersion=<project-version> \
                                    -Dsonar.sources=<project-path>"
                            }
                        }
                    }
                }
    }
}