node {
    stage("Deploy VPC"){
        build "VPCBuilder"
    }
    stage("Deploy ASG"){
        build "ASGBuilder"
    }
}