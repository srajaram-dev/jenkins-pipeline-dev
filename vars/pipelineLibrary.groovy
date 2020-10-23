def call(Map pipelineParams) 
{
  pipeline
  {	
    agent any	
    tools {
            maven 'Maven'
            jdk 'Java'
        }
      stages	
      {		
        stage('print')		
          {			
              steps			
              {				
                  sh 'java -version'
                  sh 'mvn -version'
              }		
           }
          stage('environment')		
          {			
              steps			
              {				
                  echo "ENV_NAME :::::: ${pipelineParams.ENV_NAME}"	
              }		
           }		
           stage('mavenBuild')
           {	
              steps			
              {				
                  mavenBuild()
               }		
            }	
           stage('codeScan')
           {	
              steps			
              {				
                  echo "Scan code :::::: ${pipelineParams.ENV_NAME}"	
               }		
            }	
            stage('dockerBuild')
           {	
              steps			
              {				
                  echo "Docker Build :::::: ${pipelineParams.ENV_NAME}"	
               }		
            }	
            stage('dockerDeploy')
           {	
              steps			
              {				
                  echo "Docker Deploy :::::: ${pipelineParams.ENV_NAME}"	
               }		
            }	
         }
      }
}
