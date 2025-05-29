#!/usr/bin/env bash
set -e

echo "=== Сборка всех микросервисов ==="
for service in config-server eureka-server api-gateway \
               user-service card-aggregation-service \
               analytics-service notification-service \
               recommendation-service payment-service admin-service; do
  echo "> Сборка $service"
  (cd ../$service && mvn clean package -DskipTests)
  echo "> Сборка Docker-образа для $service"
  docker build -t myregistry/finpick/$service:latest ../$service
done

echo "=== Сборка Helm-чартов ==="
helm lint helm/*.