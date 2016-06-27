import jenkins.model.*

def jobName = "php-template"
def configXml = new Url("https://raw.githubusercontent.com/sebastianbergmann/php-jenkins-template/master/config.xml").getText()
def xmlStream = new ByteArrayInputStream(configXml.getBytes())

Jenkins.instance.createProjectFromXML(jobName, xmlStream)
