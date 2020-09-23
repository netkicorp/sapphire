# Docker TransactID Sapphire Quickstart with Vault

## Requirements

- docker-compose v2

- docker >18

This application is avaialble via DockerHub at: https://hub.docker.com/r/netkicorporate/sapphire

## Setup

### Navigation

```
├── docker-compose.yaml
├── README.md
├── sapphire
│   ├── build.sh
│   ├── docker-compose.yaml
│   └── Dockerfile
└── vault
    ├── config
    │   ├── config.hcl
    │   └── policy.hcl
    ├── docker-compose.yaml
    └── Dockerfile
```

### Standard Setup

There is an install helper at the project root.

```#!/bin/bash
cd ..
./setup
```

You will be prompted to enter details to set runtime configuration.

---

### Advanced

There are 3 docker-compose files, depending on your needs:

1. docker-compose.yaml - launches sapphire with vault

2. sapphire/docker-compose.yaml - sapphire only

3. vault/docker-compose.yaml - vault only

You will have to set the following environment variables using this approach:

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

---

### Initializing Vault (optional)

We also include a very basic vault setup using a filesystem backend for storage.
Vault offers other storage backends that provide increased functionality and security: https://www.vaultproject.io/docs/configuration/storage

### Please save your unseal keys, as there is no way to recover this information

---
## Garbage Collection

`
docker-compose stop && docker-compose rm -f
`