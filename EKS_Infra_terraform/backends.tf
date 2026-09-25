terraform {
  backend "s3" {
    bucket  = "iot07092026"
    key     = "eks/terraform.tfstate"
    region  = "us-east-1"
    encrypt = true
  }
}