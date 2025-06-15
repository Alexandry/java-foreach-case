pipeline {
  agent any
  tools{
    mave 'Maven 3.9.9'
  }
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
