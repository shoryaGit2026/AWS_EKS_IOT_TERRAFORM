data "aws_availability_zones" "zns" {}

data "terraform_remote_state" "jenkins" {
  backend = "s3"

  config = {
    bucket = "iot07092026"
    key    = "dev/terraform.tfstate"
    region = "us-east-1"
  }
}