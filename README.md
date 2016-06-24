# Jenkins via Docker
## What's it?
This package allows you to run the [Jenkins CI Server](https://jenkins.io/) under [Docker](https://www.docker.com/).

Here the implementation of this idea: [Template for Jenkins Jobs for PHP Projects](http://jenkins-php.org/).

## How it works
Package contains two containers:

**jenkins** container runs the Jenkins CI Server on http://172.31.1.3:8080 address.

**nginx** container runs Nginx Web Server on http://172.31.1.2:80 address.

## How to use this package
### Getting the package
*Note: Before you need to install the [Docker](https://docs.docker.com/engine/installation/) and [Docker Compose](https://docs.docker.com/compose/install/) on your server.*
```bash
$ https://github.com/AntonKozytskyi/jenkins-php.git
$ cd jenkins-php
```

### Building the containers
First of all you have to build the containers by running next command:
```bash
$ docker-compose -p jenkins-php build
```
### Running the containers
Command bellow runs the containers. It builds the containers as well if you haven't built them before.
```bash
$ docker-compose -p jenkins-php up -d
```
### Stopping the containers
If you need to stop the containers for some reasons you can use the command bellow:
```bash
$ docker-compose -p jenkins-php stop
```
### Stopping and removing the containers
If you need to stop and remove then the containers at all you can achieve this by running:
```bash
$ docker-compose -p jenkins-php down
```
*Note: more information on how to use the Docker-Compose you can find here [Docker Compose Overview](https://docs.docker.com/compose/) and here [Compose command-line reference](https://docs.docker.com/compose/reference/).*
