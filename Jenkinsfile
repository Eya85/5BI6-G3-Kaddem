pipeline {
    agent any
    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling...'
                git branch: 'master', url: 'https://github.com/Eya85/Kaddem.git'
            }
        }
        
        stage('Clean and Build') {
            steps {
                dir('C:\Users\user\Desktop\kaddem') {
                    
                    sh 'mvn clean install'
                }
            }
        }
    }
}
