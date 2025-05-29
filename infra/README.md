# infra

1. Хранит манифесты Kubernetes (Deployments, Services, ConfigMaps, Ingress, etc.).
2. Содержит Helm-чарты для всех сервисов и общие шаблоны.
3. Включает скрипты CI/CD (build-all.sh, deploy-all.sh, rollback.sh) для автоматизации сборки, тестирования и выкатывания сервисов.
4. Может иметь Jenkinsfile или GitHub Actions-воркфлоу для интеграции с конвейером.