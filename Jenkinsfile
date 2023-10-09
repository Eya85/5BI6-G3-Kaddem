pipeline {
    agent any
    stages {
        stage('Récupération du code') {
            steps {
                git(url: 'https://github.com/votre-utilisateur/votre-projet.git', branch: 'votre-branche')
            }
        }
        stage('Nettoyage et compilation') {
            steps {
                sh 'mvn clean compile'
            }
        }
    }
}
