pipeline {
agent any

  stages {
//     stage 'checkout project'
//     checkout scm
    stage('checkout project') {
      step{
        checkout scm
      }
    }
//     stage 'check env'
//     sh "mvn -v"
//     sh "java -version"

    stage('checkout project') {
          step{
            sh "mvn -v"
            sh "java -version"
          }
    }

    stage('running tests') {
      step{
        sh "mvn test"
      }
    }

//     stage 'test'
//     sh "mvn test"

    stage('package') {
      step{
        sh "mvn package"
      }
    }
//     stage 'package'
//     sh "mvn package"

    stage('report') {
      step{
        $class: 'JUnitResultArchiver'
        testResults: '**/target/surefire-reports/TEST-*.xml'
      }
    }
//     stage 'report'
//     step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])

    stage('Artifact'){
        step{
            $class: 'ArtifactArchiver'
            artifacts: '**/target/*.jar'
            fingerprint: true
        }
    }
//     stage 'Artifact'
//     step([$class: 'ArtifactArchiver', artifacts: '**/target/*.jar', fingerprint: true])

//     stage 'Docker Deploy Hub'
//     environment {
//         registry = "anatolyilin/demoapi"
//         registryCredential = 'dockerhub'
//       }
//      step(
//             docker.build registry + ":$BUILD_NUMBER"
//       )
//
//     stage('Deploy Image') {
//       step{
//         script {
//           docker.withRegistry( '', registryCredential ) {
//             dockerImage.push()
//           }
//         }
//       }
//     }
//
//     stage('Remove Unused docker image') {
//       step{
//         sh "docker rmi $registry:$BUILD_NUMBER"
//       }
//     }
}
}