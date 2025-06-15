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

    stage('Bump Version') {
      steps {
        sh '''mvn build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.nextPatchVersion} versions:commit
'''
        sh '''git config user.name "jenkins-bot"
git config user.email "jenkins@example.com"
git add pom.xml
git commit -m "chore: bump version [ci skip]"
git push origin main
'''
      }
    }

  }
  tools {
    maven 'Maven 3.9.9'
  }
}