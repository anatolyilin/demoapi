// pipeline {
//     agent {
//         docker {
//             image 'image openjdk:8-jdk-alpine'
//             args '-p 8080:8080'
//         }
//     }
//     environment {
//         CI = 'true'
//     }
//     stages {
//         stage('Build') {
//             steps {
//                 sh 'npm install'
//             }
//         }
//         stage('Test') {
//             steps {
//                 sh './jenkins/scripts/test.sh'
//             }
//         }
//     }
// }

node {
  try{
    stage 'checkout project'
    checkout scm

    stage 'check env'
    sh "mvnw -v"
    sh "java -version"

    stage 'test'
    sh "mvnw test"

    stage 'package'
    sh "mvnw package"

    stage 'report'
    step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])

    stage 'Artifact'
    step([$class: 'ArtifactArchiver', artifacts: '**/target/*.jar', fingerprint: true])

  }catch(e){
    throw e;
  }
}