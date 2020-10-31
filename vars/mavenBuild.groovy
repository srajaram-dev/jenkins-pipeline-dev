def call() 
{
	echo ":::::::::::::: Executing mavenBuild.groovy - START :::::::::::::: "
	
	def mavenSettings = libraryResource "com/dev/configs/mvn.settings.xml"
	writeFile file: "mvn.settings.xml", text: mavenSettings
		
	def scriptContent = libraryResource "com/dev/scripts/mavenBuild.sh"
	writeFile file: "mavenBuild.sh", text: scriptContent
	sh '$WORKSPACE/mavenBuild.sh "mavenBuild.sh"'
	
	echo ":::::::::::::: Executing mavenBuild.groovy - END :::::::::::::: "
}