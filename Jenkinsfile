pipeline {
agent any

  stages {
//     stage 'checkout project'
//     checkout scm
    stage('checkout project') {
      steps{
        checkout scm
      }
    }
//     stage 'check env'
//     sh "mvn -v"
//     sh "java -version"

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

//     stage 'test'
//     sh "mvn test"

    stage('package') {
      steps{
        sh "mvn package"
      }
    }
//     stage 'package'
//     sh "mvn package"

//     stage('report') {
//       steps{
//         $class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'
//       }
//     }
//     stage 'report'
//     steps([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])

    stage('Artifact'){
        steps{
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            junit '**/target/surefire-reports/TEST-*.xml'
        }
    }
//     stage 'Artifact' $class: 'ArtifactArchiver', artifacts: '**/target/*.jar', fingerprint: true
//     steps([$class: 'ArtifactArchiver', artifacts: '**/target/*.jar', fingerprint: true])

    stage('Docker Deploy Hub'){ }

    environment {
        registry = "anatolyilin/demoapi"
        registryCredential = 'dockerhub'
      }
     steps(
            docker.build registry + ":$BUILD_NUMBER"
      )
      }

//     stage('Deploy Image') {
//       steps{
//         script {
//           docker.withRegistry( '', registryCredential ) {
//             dockerImage.push()
//           }
//         }
//       }
//     }
//
//     stage('Remove Unused docker image') {
//       steps{
//         sh "docker rmi $registry:$BUILD_NUMBER"
//       }
//     }
}
}