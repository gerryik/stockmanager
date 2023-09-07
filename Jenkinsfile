pipeline {
  agent any 
  tools {
    maven 'maven'
  }
    options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }
  environment {
    DOCKERHUB_CREDENTIALS = credentials('dockerhub')
  }


  stages{
    stage('1-git-clone'){
      steps{
        checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'jenkinsacct', url: 'https://github.com/gerryik/stockmanager.git']])
      }
    }
    stage('2-cleanws'){
      steps{
        sh 'mvn clean'
      }
    }
    stage('3-mavenbuild'){
      steps{
        sh 'mvn package'
      }
    }
    stage('sonarscanner'){
      steps{ echo " Got it" }
    }
  stage('create docker image'){
      steps{
    
        script{
            sh 'docker build -t gerryik/stockmanager:0.0.1 .'
        }
      }
    }
    

    stage('Login') {
      steps {
        sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
      }
    }
    
        stage('Push') {
      steps {
        sh 'docker push gerryik/stockmanager:0.0.1 '
      }
    }

    }
    
  post {
    always {
      sh 'docker logout'
    }
  }
}
