properties([
  parameters([
     stringParam(name: 'stringParam', defaultValue: 'atscale'),
  ])
])
def branches = [:]
def names = nodeNames()
def repoURL = "https://github.com/OmkarPathak/Python-Programs.git"
for (int i=0; i<names.size(); ++i) {
  def nodeName = names[i];
  branches["node_" + nodeName] = {
    node(nodeName) {
      try {
        stage('Checkout') {
          echo "Triggering on " + nodeName
          def res = sh(script: """
            if cd Python-Programs; then git pull; else git clone https://github.com/OmkarPathak/Python-Programs.git; fi
           """, returnStdout: true)
          }
        }
      catch (exc) {
          echo "Fail meaning stage! ${exc}"
      }
      try {
        stage('Check meaning') {
          echo "Triggering on " + nodeName
            def res = sh(script: """
               echo ${stringParam} | python3 Python-Programs/Scripts/P06_GetMeaning.py
             """, returnStdout: true)
             println res
           if (res.contains("Cannot find such word! Check spelling.")) {
              throw new Exception("Word not found")
           }
      }
        }
      catch (exc) {
          echo "Fail meaning stage! ${exc}"
      }

      finally {
           println("Code block to execute after SUCCESS/FAILURE:")
      }
      }
   }
}

parallel branches

@NonCPS
def nodeNames() {
  return jenkins.model.Jenkins.instance.nodes.collect { node -> node.name }
}
