# recommendation-service

ИИ-модуль: анализ поведения пользователей и формирование персонализированных рекомендаций.

Использует TensorFlow/Java для работы с нейросетями.

1. При старте подтягивает настройки из Config Server и регистрируется в Eureka.
2. Принимает POST /api/v1/recommendations с userId, периодом и limit.
3. Сервисный слой вызывает TensorflowModelClient.predict(...), передавая эти параметры.
4. Сохраняет полученные объекты Recommendation в базу через JPA-репозиторий.
5. Возвращает клиенту RecommendationResponse с текстом рекомендаций и их оценками.
