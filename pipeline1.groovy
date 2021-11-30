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
    stage("Plan"){
        sh 'terraform plan'
    }
    stage("Apply"){
        //sh 'terraform apply -auto-approve'
        echo 'running apply '
    }
    stage("Notification"){
        sh 'echo hello'
        //slackSend channel: 'general', message: 'VPC has been built'
    }
}
