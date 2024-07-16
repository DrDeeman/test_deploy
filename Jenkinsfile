pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat 'echo "test_dep2"'
                bat 'mvn -B -DskipTests clean package'
            }
        }
    }
}