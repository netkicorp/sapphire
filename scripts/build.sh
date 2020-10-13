#!/bin/bash
cd ../
tar czf sapphire.tar.gz --exclude='build/' --exclude='helm' --exclude='docker*' --exclude='scripts/' --exclude='*.yml' --exclude='.git*' --exclude='*.go' .
cat sapphire.tar.gz | docker build . -f docker/sapphire/Dockerfile -t netkicorporate/sapphire:latest