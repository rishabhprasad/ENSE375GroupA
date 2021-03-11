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
                sh 'cd lib/ ; wget https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.7.0/junit-platform-console-standalone-1.7.0-all.jar'
                sh 'cd ENSE375/src/main/java/com/uregina/ ; javac -cp "../lib/junit-platform-console-standalone-1.7.0-all.jar" app/App.java app/Patient.java app/PatientHistogram.java app/PatientList.java app/PostalCode.java app/RiskCodeMap.java exception/InvalidAgeException.java exception/InvalidIDException.java exception/InvalidNameException.java exception/InvalidPostalCodeException.java'
                sh 'cd ENSE375/src/test/java/com/uregina/ ; javac -cp "../lib/junit-platform-console-standalone-1.7.0-all.jar" app/AppTest.java app/PatientTest.java app/PatientHistogramTest.java app/PatientListTest.java app/PostalCodeTest.java app/RiskCodeMapTest.java'
            }
        }

        stage('Test'){
            steps{
                sh 'cd lib/ ls'
                sh 'cd ENSE375/src/test/java/com/uregina/ ; java -jar ./lib/junit-platform-console-standalone-1.7.0-all.jar -cp "." --scan-class-path --reports-dir="reports"'
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
