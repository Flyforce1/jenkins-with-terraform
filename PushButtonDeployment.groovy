node {
    stage("Deploy VPC"){
        build "VPCBuilder"
    }
    stage("Build AMI"){
        build "AMIBuilder"
    }
    stage("Deploy ASG"){
        build "ASGBuilder"
    }
}