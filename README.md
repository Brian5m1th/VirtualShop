# 🛒 Loja Virtual - Desafio Siteware

Protótipo de uma **Loja Virtual** com funcionalidades de **CRUD de produtos**, **promoções aplicadas dinamicamente no carrinho de compras** e **integração com mensageria (RabbitMQ)**, desenvolvido para o processo seletivo da **Siteware**.

---

## 🚀 Funcionalidades

- ✅ Cadastro, edição, listagem e exclusão de produtos
- 🏷️ Aplicação automática de promoções:
    - **Leve 2 e Pague 1**
    - **3 por R$10,00**
- 🛍️ Carrinho de compras com:
    - Adição, remoção e edição de itens
    - Cálculo do valor total com base nas promoções
- 🔄 Integração com **RabbitMQ** para envio de eventos de pedido finalizado

---

## 🧠 Lógica de Promoções

| Promoção              | Descrição                            |
|-----------------------|----------------------------------------|
| Leve 2 e Pague 1      | A cada 2 itens, paga-se apenas 1       |
| 3 por R$10,00         | A cada 3 itens, paga-se R$10 no total  |
| Nenhuma               | Preço cheio, sem desconto              |

---

## 🧱 Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database (pode ser trocado por PostgreSQL facilmente)
- Lombok
- Maven

---

## 🗂️ Estrutura do Projeto

src/
└── main/
├── java/
│ └── com.siteware.lojavirtual/
├─├──application/
│ ├── api/
│ ├── service/
│ ├── domain/
│ └── repository/
└── resources/
├── application.yml