def call() 
{
	echo ":::::::::::::: Executing mavenBuild.groovy - START :::::::::::::: "
		
	def scriptContent = libraryResource "com/dev/scripts/mavenBuild.sh"
	writeFile file: "mavenBuild.sh", text: scriptContent
	sh '$WORKSPACE/mavenBuild.sh "mavenBuild.sh"'
	
	echo ":::::::::::::: Executing mavenBuild.groovy - END :::::::::::::: "
}