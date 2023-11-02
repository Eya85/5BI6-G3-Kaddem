pipeline {
  agent any

  
  stages {
  

    stage('Cleaning the Project') {
      steps {
         sh 'echo "*********Clean the Project is processing ....*********"'
        sh 'mvn clean'
      }
    }
    
    stage ('Artifact construction') {
            steps {
                sh 'echo "*********Artifact construction is processing ....*********"'
                sh 'mvn -DskipTests package'
            }
        }

    stage('Docker build ') {
      steps {
         sh 'echo "*********Docker build image is processing ....*********"'
        sh 'docker build -t ${dockerhubusername}/kaddem .'
      }
    }

     stage('Docker login') {
      steps {
         sh 'echo "*********Docker login is processing ....*********"'
        sh 'docker login --username ${dockerhubusername} --password ${dockerhubpassword}'

      }
    }
    stage('Docker push') {
      steps {
         sh 'echo "*********Docker push is processing ....*********"'
        sh 'docker push ${dockerhubusername}/kaddem'

      }
    }/*
    stage('Docker Compose') {
      		steps {
         		sh 'docker-compose up -d'
			echo "*********Apllication Is Started *********"
      }
    }*/
    stage("NEXUS") {
			steps {
				sh 'mvn clean deploy -DskipTests'
				echo "*********NEXUS deployement finished with SUCCESS *********"
          }
        }
    stage("SonarQube ") {
            steps {
              withSonarQubeEnv('SonarQube') {
                sh 'mvn clean -DskipTests package sonar:sonar'
		echo "*********SonarQube analysis finished with SUCCESS *********"
              }
            }
    }
    /*
    stage('Junit/Mockito Testing') {
      steps {
         sh 'echo "*********Junit / Mockito Test is processing .... *********"'
        sh 'mvn  test'
      }
    }*/


  }
}