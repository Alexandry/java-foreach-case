pipeline {
  agent any
  tools{
    maven 'Maven 3.9.9'
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
