node {
  try{
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

    stage('checkout project') {
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

    stage('report') {
      steps{
        $class: 'JUnitResultArchiver'
        testResults: '**/target/surefire-reports/TEST-*.xml'
      }
    }
//     stage 'report'
//     step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])

    stage('Artifact'){
        steps{
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

  }catch(e){
    throw e;
  }
}