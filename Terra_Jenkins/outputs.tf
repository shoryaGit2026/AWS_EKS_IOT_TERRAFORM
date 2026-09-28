output "vpc_id" {
  description = "ID of the Jenkins VPC shared with EKS"
  value       = module.vpc.vpc_id
}

output "public_subnet_ids" {
  description = "Public subnet IDs available to the EKS cluster"
  value       = module.vpc.public_subnets
}