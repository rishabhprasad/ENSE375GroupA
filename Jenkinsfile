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
                sh 'mkdir ENSE375/lib'
                sh 'mvn compile -f "~/var/jenkins_home/workspace/RiskMeter/pom.xml"'
                //sh 'cd ENSE375/lib/ ; wget https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.7.0/junit-platform-console-standalone-1.7.0-all.jar'
                //sh 'cd ENSE375/src/ ; mkdir bin; javac -d bin -cp ../lib/junit-platform-console-standalone-1.7.0-all.jar $(find . -name "*.java")'
            } 
        }

        stage('Test'){
            steps{
                sh 'mvn test -f "~/var/jenkins_home/workspace/RiskMeter/pom.xml"'
                //sh 'cd ~/workspace/ense375-groupA/ENSE375/src/; java -jar ../lib/junit-platform-console-standalone-1.7.0-all.jar -cp bin --scan-class-path'
            }
        }
    }

}
