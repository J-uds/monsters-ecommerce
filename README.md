# 🧪 Monster Product API

RESTful API to manage a product catalog and user reviews. Built with **Spring Boot** following clean architecture and good development practices.

---

## 📦 Technologies Used

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL 
- dotenv-java
- IntelliJ IDEA
- Jakarta Validation
- Layered architecture: Controller - Service - Repository - Model - DTO

---

## 🧩 Project Structure

```
com.monsters
├── controllers      ← REST Controllers (API)
├── dtos             ← Data Transfer Objects (Request/Response)
├── models           ← JPA Entities (Product, Review)
├── repositories     ← Data Access Interfaces
├── services         ← Business Logic
```

---

## 📚 Available Endpoints

### 🔹 Products

| Method | URL               | Description                      |
|--------|-------------------|----------------------------------|
| GET    | `/product`        | Get all products                 |
| GET    | `/product/{id}`   | Get product by ID                |
| POST   | `/product`        | Create a new product             |
| PUT    | `/product/{id}`   | Update an existing product       |
| DELETE | `/product/{id}`   | Delete a product by ID           |

**Example `ProductRequest`:**
```json
{
  "name": "Snowball",
  "price": 99.99,
  "imageUrl": "http://img.com/snowball.jpg",
  "featured": true
}
```

---

### 🔸 Reviews

| Method | URL                      | Description                             |
|--------|--------------------------|-----------------------------------------|
| GET    | `/review/{productId}`    | Get all reviews for a product           |
| POST   | `/review`                | Add a new review to a product           |

**Example `ReviewRequest`:**
```json
{
  "userName": "Monster of the North",
  "rating": 4.5,
  "body": "Great quality and price.",
  "productId": 1
}
```

---

## 🧠 Key Concepts

### ✅ Best Practices Applied

- **Layered architecture**: Clear separation of responsibilities.
- **DTO usage**: Prevent exposing entities directly through the API.
- **Validation**: Enforced using annotations like `@NotBlank`.
- **Error handling**: With `ResponseStatusException` for proper HTTP responses (404, 400, etc.).
- **Mappers**: Clean conversion between entity and DTO objects.

---

## 🚀 How to Run the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/J-uds/monsters-ecommerce.git
   cd monsters-ecommerce
   ```

2. Open the project using IntelliJ or another Java IDE.

3. Run the `MonstersApplication.java` class.

4. Access the API at `http://localhost:8080`.

---

## 🛠 Future Improvements

- JWT Authentication & Authorization
- Product filtering and pagination
- Unit and integration tests

---

## 🧙‍♂️ Author

Created by J-uds.