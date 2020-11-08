1. Run the following command to setup user credentials to be used for initial admin user

```
source ./setup_env_vars.sh <JENKINS username> <JENKINS password> <JENKINS slave replicas number>
```

example:

```
source ./setup_env_vars.sh jenkins jenkins 3
```

2. Start a Jenkins master with the defined credentials and slave replicas from step. 1

```
docker-compose up -d
```

3. Access JENKINS UI at http://localhost:8080

*** Since this is a local example, SSL certs and HTTPS has not been enabled,
if required, this is how it should be done with Jenkins native SSL:
 - generate SSL and convert to JKS providing a domain to be certified via keytool
 - map ports 8443:8443 in compose
 - setup SSL by adding the following properties to the JENKINS_OPTS env section in compose:
``` 
--httpPort=-1
--httpsPort=8443
--httpsKeyStore="%JENKINS_HOME%\your-keystore.jks"
--httpsKeyStorePassword="<cleartext-password-to-keystore>"
```
 
4. Create a Pipeline project 
 - Pipeline -> Pipeline Script from SCM -> Git
 - Enter https://github.com/BoykoDimitrov/atscale_jenkins.git as the source repository
 - Enter */main as the branch specifier
 
5. Go to http://localhost:8080/scriptApproval/ and these methods for approval:
``` 
field hudson.model.Slave name
method hudson.model.AbstractCIBase getNodes
staticMethod jenkins.model.Jenkins getInstance
```   
   


