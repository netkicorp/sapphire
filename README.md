# Setup

## Requirements

Make sure that you have installed in your machine
- Java 13
- Gradle

## Standard Setup (Recommended)

There is an install helper at the project root.

```#!/bin/bash
./setup
```

You will be prompted to enter details to set runtime configuration and guided through various setup methods we have available.

---

## Advanced without Docker

To run project directly, _configure the required environment variables_ and then run the project using gradle.


### Environment Variables 

Before running the project you need to set some environment variables, the details of each one are:

```#!/bin/bash
INSTALLDIR - this  is the location the application is installed

TRUSTSTORE_LOCATION - this is the path to the certificate trustore, the project includes one in src/main/resources/certificates 
 so you can set the abosulte path of that folder in this variable. (Mandatory)

MERKLE_KEY - key provided by Merkle to access address information. (Optional)

CERTIFICATE_PROVIDER_AUTHORIZATION_KEY - key provided by Netki to generate certificates. (Mandatory)

STORAGE_AUTHORIZATION_KEY - If you are using vault to store the keys, this is the key to use your Vault instance (Optional)

STORAGE_ADDRESS - If you are using vault to store the keys, this is the address of your Vault instance (Optional)

CERTIFICATE_PROVIDER_URL - Change this if you want to point to different Certificate provider, ** This is recommended to do not change ** (Optional and not recommended)
```

#### Example

In `bash` shell, to set the`CERTIFICATE_PROVIDER_AUTHORIZATION_KEY` in your bash profile:

Open the bash file to edit with

```script
vi ~/.bash_profile
```

Add the variable

```script
export CERTIFICATE_PROVIDER_AUTHORIZATION_KEY=0000111112222223333333
```

Reload the bash file

```script
source ~/.bash_profile
```

To validate it was exported correctly you can check with

```script
echo $CERTIFICATE_PROVIDER_AUTHORIZATION_KEY
```

Note:
If you are using IntelliJ or Eclipse make sure to restart your IDE after you set the variables.

---

### Running the project

Go to the root folder of the project and execute the following command:

```script
./gradlew bootRun
```

---

## Advanced with Docker

To run this project with Docker, _configure the required environment variables_ and then run `docker-compose up -d` in the desired directory.

see docker/README.md for details

---

## Advanced with Helm for Kubernetes

For Kubernetes, a Helm Chart is included in the helm folder.
_Configure the environment variables_ below

see helm/README.md for details

---

### Checking status

To check the status of the service, you can use the url

```url
{{HOST}}/health
```
