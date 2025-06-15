pipeline {
  agent any

  tools {
    maven 'Maven 3.9.9'
  }

  environment {
    TZ = "UTC" // Garantir consistência de horário
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

    stage('Set Version') {
      steps {
        script {
          // Recupera a versão base do POM
          def baseVersion = sh(
            script: "mvn help:evaluate -Dexpression=project.version -q -DforceStdout",
            returnStdout: true
          ).trim().replace("-SNAPSHOT", "")

          // Bump de patch
          def parts = baseVersion.tokenize('.')
          parts[-1] = (parts[-1].toInteger() + 1).toString()
          def bumped = parts.join('.')

          // Timestamp para SNAPSHOTs
          def timestamp = new Date().format("yyyyMMdd-HHmm", TimeZone.getTimeZone("UTC"))
          def newVersion = ""

          if (env.BRANCH_NAME == "main") {
            newVersion = bumped
          } else {
            newVersion = "${bumped}-${timestamp}-SNAPSHOT"
          }

          echo "Versão definida: ${newVersion}"
          env.PROJECT_VERSION = newVersion
          sh "mvn versions:set -DnewVersion=${newVersion} versions:commit"
        }
      }
    }

    stage('Push Version') {
      steps {
        withCredentials([usernamePassword(
          credentialsId: '766587d2-ba03-464f-9c67-cbf64fdc3531',
          usernameVariable: 'GIT_USER',
          passwordVariable: 'GIT_TOKEN'
        )]) {
          sh """
            git config user.name "jenkins-bot"
            git config user.email "jenkins@example.com"
            git remote set-url origin https://${GIT_USER}:${GIT_TOKEN}@github.com/Alexandry/java-foreach-case.git
            git add pom.xml
            git diff --cached --quiet || git commit -m "chore: set version ${PROJECT_VERSION} [ci skip]"
            git push origin ${env.BRANCH_NAME}
          """
        }
      }
    }
  }
}
