pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn compile'
      }
    }

    stage('Tests') {
      steps {
        sh 'mvn clean test'
      }
    }

  }
}