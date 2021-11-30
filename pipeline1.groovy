node {
    stage("Clone A Repository") {
        git 'https://github.com/farrukh90/jenkins-class-august.git'
    }
    stage("Initialize"){
        sh 'terraform init'
    }
}
