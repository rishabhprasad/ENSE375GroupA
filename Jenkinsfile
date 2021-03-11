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
                sh 'mkdir lib'
                sh 'cd  ENSE375/src/ ; wget https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.7.0/junit-platform-console-standalone-1.7.0-all.jar'
                sh 'cd ENSE375/src/; mkdir bin; javac -d bin -cp junit-platform-console-standalone-1.7.0-all.jar $(find . -name "*.java")'
            } 
        }

        stage('Test'){
            steps{
                sh script:'''
                #!/bin/bash
                echo "This is start $(pwd)"
                mkdir hello
                cd ./hello
                echo "This is $(pwd)"
                '''
                sh  'ls'
                sh 'cd ~/workspace/ProjectStep3/ENSE375/src/; java -jar junit-platform-console-standalone-1.7.0-all.jar -cp bin --scan-class-path'
                junit 'ENSE375/src/reports/*-jupiter.xml'
                
               
        }
       }
        // stage('Deploy'){
        //     steps{
        //         sh 'cd src/ ; java Calculator' 
        //     }
        // }
    }

}
