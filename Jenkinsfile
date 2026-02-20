pipeline {
    agent any
    environment {
        PATH = "/usr/local/bin:/usr/bin:/bin:$PATH"
    }
    tools{
        jdk 'JDK21'
        maven 'maven_3.9.12'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Haphor17/devops-demo']])
                sh 'mvn clean install'
            }
        }
        stage('Check PATH') {
            steps {
                sh 'echo $PATH'
                sh 'which docker || echo "Docker not found"'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t haphor/devops-demo .'
                }
            }
        }
        stage('Push docker image'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerHubPwd', variable: 'dockerHubPwd')]) {
                        sh 'docker login -u haphor -p ${dockerHubPwd}'
                    }
                    sh 'docker push haphor/devops-demo'
                }
            }
        }
    }
}