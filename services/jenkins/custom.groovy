import jenkins.model.*

def jobName = "php-template"
def configXml = new URL("https://raw.githubusercontent.com/sebastianbergmann/php-jenkins-template/master/config.xml").getText()
def xmlStream = new ByteArrayInputStream(configXml.getBytes())

// TODO: don't create a job if already exists
Jenkins.instance.createProjectFromXML(jobName, xmlStream)
