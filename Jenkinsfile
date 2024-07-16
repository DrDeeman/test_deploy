pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat 'echo "test_dep"'
                bat 'mvn -B -DskipTests clean package'
            }
        }
    }
}