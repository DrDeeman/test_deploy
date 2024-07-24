node{

          NEXUS_VERSION = "nexus3"
          NEXUS_PROTOCOL = "http"
          NEXUS_URL = "127.0.0.1:8081"
          NEXUS_REPOSITORY = "test_repository"
          NEXUS_CREDENTIAL_ID = "nexus-user-credentials"


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
                               bat "mvn clean verify"
                               bat "${scannerHome}/bin/sonar-scanner \
                                                                   -D sonar.projectKey=sonar_project \
                                                                   -D sonar.java.coveragePlugin=jacoco \
                                                                   -D sonar.jacoco.reportPath=target/jacoco.exec \
                                                                   -D sonar.projectVersion=1.0 \
                                                                   -D sonar.java.binaries=target \
                                                                   -D sonar.host.url=http://localhost:9000 \
                                                                   -D sonar.token=sqp_f11eb091e8c50024a813cb5dd205a1fba0ea434a"
                                    }
                }

        stage("Quality Gate"){
             timeout(time:1, unit:"MINUTES"){
                def qg = waitForQualityGate()
                if(qg.status !='OK'){
                   error "Quality Gate not allowed"
                }
             }
        }

        stage("Load artifact in Nexus"){
              nexusArtifactUploader(
                                     nexusVersion: NEXUS_VERSION,
                                     protocol: NEXUS_PROTOCOL,
                                     nexusUrl: NEXUS_URL,
                                     groupId: groupId,
                                     version: version,
                                     repository: NEXUS_REPOSITORY,
                                     credentialsId: NEXUS_CREDENTIAL_ID,
                                     files: [
                                         [file: 'target/your-artifact.jar', classifier: '', type: 'jar']
                                     ]
                                 )
        }

}