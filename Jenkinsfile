pipeline {
    agent any
    stages {
          stage('Fetch Code') {
                    steps {
                        git "https://github.com/DrDeeman/test_deploy.git"
                    }
                }

        stage('Code Analysis') {
                    environment {
                        scannerHome = tool 'test_sonar'
                    }
                    steps {
                        script {
                            withSonarQubeEnv('test_sonar') {
                                sh "${scannerHome}/bin/sonar-scanner \
                                    -Dsonar.projectKey=FSP \
                                    -Dsonar.projectName=sonar_project \
                                    -Dsonar.projectVersion=1.0"
                            }
                        }
                    }
                }
    }
}