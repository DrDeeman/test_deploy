node{

          stage('Fetch Code') {
                    git "https://github.com/DrDeeman/test_deploy.git"
                }


          stage('Run tests'){
              withMaven(){
                     bat "mvn test"
                  }
          }

        stage('Code Analysis') {
                     script {
                              scannerHome = tool 'test_sonar'
                            }
                            withSonarQubeEnv('test_sonar') {
                                bat "mvn clean verify sonar:sonar \
                                    -D sonar.projectKey=sonar_project \
                                    -D sonar.java.coveragePlugin=jacoco \
                                    -D sonar.jacoco.reportPath=target/jacoco.exec \
                                    -D sonar.java.binaries=target \
                                    -D sonar.host.url=http://localhost:9000"
                                    }
                }

        stage("Quality Gate"){
             timeout(time:1, unit:"MINUTES"){
                def qg = waitForQualityGate(webhookSecretId: 'Tesari7612345678')
                if(qg.status !='OK'){
                   error "Quality Gate not allowed"
                }
             }
        }

}