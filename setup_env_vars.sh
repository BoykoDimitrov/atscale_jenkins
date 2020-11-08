#!/bin/bash

# Strict Mode - http://redsymbol.net/articles/unofficial-bash-strict-mode/
set -euo pipefail
IFS=$'\n\t'

export JENKINS_USER=$1
export JENKINS_PASS=$2
export JENKINS_SLAVE_REPLICAS=$3
