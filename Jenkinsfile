pipeline {
    environment {
        registry = "anatolyilin/demoapi"
        registryCredential = 'dockerhub'
      }

agent any

  stages {

    stage('checkout project') {
      steps{
        checkout scm
      }
    }

    stage('check env') {
          steps{
            sh "mvn -v"
            sh "java -version"
          }
    }

    stage('running tests') {
      steps{
        sh "mvn test"
      }
    }

    stage('package') {
      steps{
        sh "mvn package"
      }
    }

    stage('Artifact'){
        steps{
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            junit '**/target/surefire-reports/TEST-*.xml'
        }
    }

    stage('Docker Deploy Hub'){
    steps{
         script {
                   dockerImage = docker.build registry + ":alternative"
//                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
         }
    }

    stage('Deploy Image') {
        steps{
            script {
                docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                      }
            }
        }
    }

    stage('Remove Unused docker image') {
        steps{
            sh "docker rmi $registry:alternative"
//             sh "docker rmi $registry:$BUILD_NUMBER"
          }
    }

}
}