
terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 6.0"
    }
  }

  required_version = ">= 1.6.0"
}



#VPC
module "vpc" {
  source = "terraform-aws-modules/vpc/aws"

  name = "jenkins-vpc"
  cidr = var.vpc_cidr

  azs            = data.aws_availability_zones.zns.names
  public_subnets = var.public_subnets

  enable_dns_hostnames = true

  tags = {
    name                                   = "jenkins-vpc"
    Terraform                              = "true"
    Environment                            = "dev"
    "kubernetes.io/cluster/my-eks-cluster" = "shared"
  }

  public_subnet_tags = {
    "kubernetes.io/cluster/my-eks-cluster" = "shared"
    "kubernetes.io/role/elb"               = "1"
  }
}

#SG
module "sg" {
  source = "terraform-aws-modules/security-group/aws"

  name        = "jenkins-sg"
  description = "jenkins security group"
  vpc_id      = module.vpc.vpc_id

  ingress_rules = {
    http = {
      from_port   = 8080
      to_port     = 8080
      ip_protocol = "tcp"
      cidr_ipv4   = "0.0.0.0/0"
      description = "HTTP"
    },
    ssh = {
      from_port   = 22
      to_port     = 22
      ip_protocol = "tcp"
      cidr_ipv4   = "0.0.0.0/0"
      description = "SSH"
    }
  }

  egress_rules = {
    all = {
      from_port   = 0
      to_port     = 0
      ip_protocol = "-1"
      cidr_ipv4   = "0.0.0.0/0"
      description = "Allow outbound traffic"
    }
  }
  enable_exclusive_rules = true

  tags = {
    name = "jenkins-sg"
  }


}


#EC2

module "ec2_instance" {
  source = "terraform-aws-modules/ec2-instance/aws"

  name = "jenkins-server"

  instance_type               = var.instance_type
  key_name                    = "Jenkins-server"
  monitoring                  = true
  subnet_id                   = module.vpc.public_subnets[0]
  vpc_security_group_ids      = [module.sg.id]
  associate_public_ip_address = true
  user_data                   = file("jenkins-install.sh")
  user_data_replace_on_change = true
  availability_zone           = data.aws_availability_zones.zns.names[0]

  tags = {
    name        = "Jenkins-server"
    Terraform   = "true"
    Environment = "dev"
  }
}