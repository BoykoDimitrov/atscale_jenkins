#!groovy

import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()
def env = System.getenv()
def adminUsername = env.get('JENKINS_USER')
def adminPassword = env.get('JENKINS_PASS')
def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount(adminUsername,adminPassword)
instance.setSecurityRealm(hudsonRealm)
def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
instance.setAuthorizationStrategy(strategy)
instance.save()