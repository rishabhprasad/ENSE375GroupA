pipeline {

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
                snykSecurity snykInstallation: 'Snyk', snykTokenId: 'ense375-snyk-api-token'
                sh 'mvn compile -f RiskMeter/pom.xml'
            } 
        }

        stage('Test'){
            steps{
                sh 'mvn test -f RiskMeter/pom.xml'


        }
       }
    }

}
