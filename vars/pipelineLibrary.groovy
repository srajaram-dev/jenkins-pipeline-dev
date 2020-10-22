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
                  echo "Maven Build :::::: ${pipelineParams.ENV_NAME}"	
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
