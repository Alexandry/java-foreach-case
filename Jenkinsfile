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
        sh '''mvn build-helper:parse-version versions:set \\
  -DnewVersion=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout | awk -F. \'{$NF+=1; print $1"."$2"."$NF}\') \\
  versions:commit'''
        sh '''git add pom.xml
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