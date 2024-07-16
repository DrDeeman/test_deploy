pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat 'echo "test_dep5"'
                bat 'mvn -B -DskipTests clean package'
            }
        }
    }
}