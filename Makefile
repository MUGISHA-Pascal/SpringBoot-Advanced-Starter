.PHONY: help build run stop clean logs dev prod

help: ## Show this help message
	@echo 'Usage: make [target]'
	@echo ''
	@echo 'Targets:'
	@awk 'BEGIN {FS = ":.*?## "} /^[a-zA-Z_-]+:.*?## / {printf "  %-15s %s\n", $$1, $$2}' $(MAKEFILE_LIST)

build: ## Build the Docker image
	docker-compose build

run: ## Start the application in development mode
	docker-compose up -d

stop: ## Stop all containers
	docker-compose down

clean: ## Stop containers and remove volumes
	docker-compose down -v
	docker system prune -f

logs: ## Show application logs
	docker-compose logs -f app

dev: ## Start development environment with hot reload
	docker-compose -f docker-compose.yml -f docker-compose.override.yml up -d

prod: ## Start production environment
	docker-compose -f docker-compose.prod.yml up -d

restart: ## Restart the application
	docker-compose restart app

shell: ## Open shell in the application container
	docker-compose exec app /bin/bash

db-shell: ## Open shell in the database container
	docker-compose exec db psql -U postgres -d springboot_starter 