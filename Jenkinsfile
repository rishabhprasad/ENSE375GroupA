pipeline {

    environment {
        registry = "rishabhprasad03/ense375group-a"
        registryCredential = 'dockerhub'
        dockerImage = '';
    }

    agent any
    stages {

        stage('Checkout Codebase'){
            steps{
                cleanWs()
                checkout scm: [$class: 'GitSCM', branches: [[name: '*/master']],userRemoteConfigs:
                [[credentialsId: 'github-ssh-key', url: 'git@github.com:rishabhprasad/ENSE375GroupA.git']]]
            }
        }

        stage('Build'){
            steps{            
                sh 'mvn compile -f RiskMeter/pom.xml'               
            } 
        }

        stage('Test'){
            steps{            
                sh 'mvn test -f RiskMeter/pom.xml'              
            }
        }
        
        stage('Building image') {
            steps{
                script {
                    dockerImage = docker.build registry
                }
            }
        }

        stage('Deploy image') {
            steps{
                script {
                    docker.withRegistry( '', registryCredential) {
                        dockerImage.push()
                    }
                }
            }
        }
    }

}
