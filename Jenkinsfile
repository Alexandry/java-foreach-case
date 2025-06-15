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
        // Atualiza a versão do pom.xml para o próximo patch
        sh '''
          mvn build-helper:parse-version versions:set \
            -DnewVersion=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout | awk -F. '{$NF+=1; print $1"."$2"."$NF}') \
            versions:commit
        '''

        // Bloco seguro com credencial
        withCredentials([usernamePassword(credentialsId: '766587d2-ba03-464f-9c67-cbf64fdc3531', usernameVariable: 'GIT_USER', passwordVariable: 'GIT_TOKEN')]) {
          sh """
            git config user.name "jenkins-bot"
            git config user.email "jenkins@example.com"
            git remote set-url origin https://${GIT_USER}:${GIT_TOKEN}@github.com/Alexandry/java-foreach-case.git
            git add pom.xml
            git diff --cached --quiet || git commit -m "chore: bump version [ci skip]"
            git push origin main
          """
        }
      }
    }

  }
  tools {
    maven 'Maven 3.9.9'
  }
}
