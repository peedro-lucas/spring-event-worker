# Spring Event Worker com RabbitMQ

Projeto backend em **Java + Spring Boot** que demonstra **processamento assíncrono orientado a eventos**
utilizando **RabbitMQ** e **Docker**.  
O objetivo é mostrar como desacoplar responsabilidades no backend usando **mensageria**, permitindo
maior escalabilidade, organização e facilidade de evolução do sistema.

---

## 🧠 Visão geral

O fluxo do projeto segue o modelo **event-driven**:

1. Um **publisher** dispara um evento/mensagem
2. A mensagem é enviada para uma **fila RabbitMQ**
3. Um **consumer (worker)** consome a mensagem e executa o processamento necessário

Esse padrão é comum em sistemas backend que precisam:
- evitar processamento síncrono pesado
- lidar com picos de carga
- manter serviços desacoplados

---

## 🧰 Tecnologias utilizadas

- Java 17+
- Spring Boot
- RabbitMQ
- Docker
- Docker Compose
- Maven

---

