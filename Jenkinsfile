pipeline {
  agent any
  stages {
    stage('') {
      steps {
        sh 'sh mvn compile'
        sh 'sh mvn clean tests'
        sh 'sh mvn package'
      }
    }

  }
}