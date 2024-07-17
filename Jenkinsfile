pipeline {
    agent any
    stages {

          stage('Fetch Code') {
                    steps {
                        git "https://github.com/DrDeeman/test_deploy.git"
                    }
                }

          stage('Run tests'){
             steps{
                   withMaven{
                       bat "mvn clean install"
                   }
             }
          }

        stage('Code Analysis') {
                    environment {
                        scannerHome = tool 'test_sonar'
                    }
                    steps {
                        script {
                            withSonarQubeEnv('test_sonar') {
                                bat "${scannerHome}/bin/sonar-scanner \
                                    -D sonar.projectKey=sonar_project \
                                    -D sonar.java.coveragePlugin=jacoco \
                                    -D sonar.jacoco.reportPath=target/jacoco.exec \
                                    -D sonar.java.checkstyle.reportPaths=target/site/index.html \
                                    -D sonar.projectVersion=1.0 \
                                    -D sonar.java.binaries=target \
                                    -D sonar.host.url=http://localhost:9000 \
                                    -D sonar.token=sqp_f11eb091e8c50024a813cb5dd205a1fba0ea434a"
                            }
                        }
                    }
                }
    }
}