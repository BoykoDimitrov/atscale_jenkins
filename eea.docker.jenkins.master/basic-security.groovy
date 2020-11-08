#!groovy

import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()
def env = System.getenv()
def hudsonRealm = new HudsonPrivateSecurityRealm(false)
def adminUsername = env.get('JENKINS_USER')
def adminPassword = env.get('JENKINS_PASS')
hudsonRealm.createAccount(adminUsername,adminPassword)
instance.setSecurityRealm(hudsonRealm)
instance.save()