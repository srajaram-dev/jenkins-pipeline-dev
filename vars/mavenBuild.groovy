def call() 
{
	echo ":::::::::::::: Executing mavenBuild.groovy :::::::::::::: "	
	def scriptContent = libraryResource "com/dev/scripts/mavenBuild.sh"
	writeFile file: "mavenBuild.sh", text: scriptContent
	sh 'mavenBuild.sh "mavenBuild.sh"'
}