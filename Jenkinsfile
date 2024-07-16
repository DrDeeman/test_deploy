pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat 'echo "test_dep8"'
                bat 'mvn -B -DskipTests clean package'
            }
        }
    }
}