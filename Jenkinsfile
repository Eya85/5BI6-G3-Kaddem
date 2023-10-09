pipeline {
    agent any
    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling...'
                git branch: 'master', url: 'https://github.com/Syrinebaklouti/kaddem.git'
            }
        }
        
        stage('Clean and Build') {
            steps {
                dir('C:\\Users\\Syrine\\Desktop\\kaddem') {
                    
                    sh 'mvn clean install'
                }
            }
        }
    }
}
