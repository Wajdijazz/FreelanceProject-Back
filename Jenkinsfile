node {
  def mvn = tool (name: 'maven3', type: 'maven') + '/bin/mvn'
  stage('SCM Checkout'){
	git branch: 'master', 
	credentialsId: 'github', 
   	url: 'https://github.com/Wajdijazz/FreelanceProject-Back'
   }
  stage('Mvn Package'){   
	sh "${mvn} clean package deploy"
   }
}
