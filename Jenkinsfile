pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat 'echo "test_dep9"'
                bat 'mvn -B -DskipTests clean package'
            }
        }

        stage('Code Analysis') {
                    environment {
                        scannerHome = tool 'Sonar'
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