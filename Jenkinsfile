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
                                bat "${scannerHome}/bin/sonar-scanner \
                                    -D sonar.projectKey=FSP \
                                    -D sonar.projectName=sonar_project \
                                    -D sonar.projectVersion=1.0 \
                                    -D sonar.token=sqp_f11eb091e8c50024a813cb5dd205a1fba0ea434a"
                            }
                        }
                    }
                }
    }
}