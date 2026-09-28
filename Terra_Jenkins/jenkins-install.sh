#!/usr/bin/env bash

set -Eeuo pipefail

if ! command -v sudo >/dev/null 2>&1; then
	echo "sudo is required to run this script."
	exit 1
fi

sudo -v

echo "Updating system packages..."
sudo dnf install -y ca-certificates dnf-plugins-core fontconfig java-21-amazon-corretto git unzip

echo "Installing Jenkins repository..."
sudo curl -fsSL https://pkg.jenkins.io/rpm-stable/jenkins.repo \
	-o /etc/yum.repos.d/jenkins.repo

echo "Installing Terraform and kubectl..."
sudo dnf config-manager --add-repo https://rpm.releases.hashicorp.com/AmazonLinux/hashicorp.repo
sudo tee /etc/yum.repos.d/kubernetes.repo >/dev/null <<'EOF'
[kubernetes]
name=Kubernetes
baseurl=https://pkgs.k8s.io/core:/stable:/v1.34/rpm/
enabled=1
gpgcheck=1
repo_gpgcheck=1
gpgkey=https://pkgs.k8s.io/core:/stable:/v1.34/rpm/repodata/repomd.xml.key
EOF
sudo dnf install -y jenkins terraform kubectl

echo "Enabling and starting Jenkins..."
sudo systemctl enable --now jenkins

echo
echo "Installation complete. Versions:"
java -version
git --version
terraform version
kubectl version --client
sudo systemctl --no-pager --full status jenkins | sed -n '1,8p'
echo
echo "Jenkins initial admin password:"
sudo cat /var/lib/jenkins/secrets/initialAdminPassword
