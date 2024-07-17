pipeline {
    agent any
    stages {

          stage('Fetch Code') {
                    steps {
                        git "https://github.com/DrDeeman/test_deploy.git"
                    }
                }

          stage('Settings workers'){
             withMaven(){}
             withSonarQubeEnv('test_sonar') {}

          }

          stage('Run tests'){
             steps{
                  bat "mvn test"
             }
          }

        stage('Code Analysis') {
                    steps {
                                bat "mvn clean verify sonar:sonar \
                                    -D sonar.projectKey=sonar_project \
                                    -D sonar.java.coveragePlugin=jacoco \
                                    -D sonar.jacoco.reportPath=target/jacoco.exec \
                                    -D sonar.java.binaries=target \
                                    -D sonar.host.url=http://localhost:9000 \
                                    -D sonar.token=sqp_f11eb091e8c50024a813cb5dd205a1fba0ea434a"
                    }
                }
    }
}