#!/bin/bash

NAMESPACE=ingress-nginx

helm install ingress-nginx ingress-nginx/ingress-nginx \
    --create-namespace \
    --namespace $NAMESPACE \
    -f values.yaml
