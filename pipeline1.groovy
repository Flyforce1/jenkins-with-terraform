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
        sh 'terraform apply -auto-approve'
    }
    stage("Notification"){
        sh 'echo hello'
    }
}
