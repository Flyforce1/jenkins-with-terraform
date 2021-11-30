properties([
    pipelineTriggers([cron('*/15 * * * *')])
])




node {
    stage("Clone A Repository") {
        checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/farrukh90/jenkins-class-august.git']]])
    }
    stage("Initialize"){
        sh 'terraform init'
    }
    stage("Run Script"){
        sh label: '', script: 
		'''#!/bin/bash
			if [ ! -d /tmp/foo ]; 
			then
				echo "Folder not found!"
				echo "Creating a folder"
				mkdir -p "/tmp/foo"
			fi
		'''
    }
    stage("Plan"){
        sh 'terraform plan'
    }
    stage("Confirmation"){
        //input 'Should I apply?'
        echo "Hello"
    }
    stage("Apply"){
        //sh 'terraform apply -auto-approve'
        echo 'running apply '
    }
    stage("Security Check"){
        sh label: '', script: 
		'''#!/bin/bash
			if [ ! -d /tmp/foo ]; 
			then
				echo "Folder not found!"
				echo "Creating a folder"
				mkdir -p "/tmp/foo"
			fi
		'''
    }
    stage("Wait"){
        sleep 10
    }
    stage("Notification"){
        sh 'echo hello'
        //slackSend channel: 'general', message: 'VPC has been built'
    }
    stage("Send message to a Contractor"){
        mail bcc: '', body: '''Hi, VPC has been built Thanks''', cc: '', from: '', replyTo: '', subject: 'VPC being built', to: 'contractor@company.com'    }
}
