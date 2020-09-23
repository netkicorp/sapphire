# Sapphire Helm Chart

For Kubernetes, we offer a Helm chart for deployment.

## Important

Ensure you have set the appropriate environment variables.
see ../README.md for details

## Deployment

To deploy into your default context namespace:

```#!/bin/bash
cd sapphire
helm create sapphire ./
```

## Garbage Collection

```#!/bin/bash
helm delete --purge sapphire
```
