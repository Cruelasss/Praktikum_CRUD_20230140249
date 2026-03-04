
---

# 📘 User API Documentation

## 🔗 Base URL

```
/api/users
```

---

## 1️⃣ Create User

**Method:** `POST`
**Endpoint:** `/api/users`

### Request Body

```json
{
  "name": "Choirul Amir Siregar",
  "age": 23
}
```

### Response

```json
{
  "status": "success",
  "data": [
    {
      "id": "f28444e9-4df8-4972-b2df-c6ee055ac9a0",
      "name": "Choirul Amir Siregar",
      "age": 23
    }
  ]
}
```

---

## 2️⃣ Update User

**Method:** `PUT`
**Endpoint:** `/api/users/{id}`

### Request Body

```json
{
  "name": "Choirul Amir Siregar",
  "age": 25
}
```

### Response

```json
{
  "status": "success",
  "message": "User berhasil diperbarui",
  "data": {
    "id": "f28444e9-4df8-4972-b2df-c6ee055ac9a0",
    "name": "Choirul Amir Siregar",
    "age": 25
  }
}
```

---

## 3️⃣ Delete User

**Method:** `DELETE`
**Endpoint:** `/api/users/{id}`

### Response

```json
{
  "status": "success",
  "message": "User berhasil dihapus dengan id f28444e9-4df8-4972-b2df-c6ee055ac9a0"
}
```

---

## 4️⃣ Get All Users

**Method:** `GET`
**Endpoint:** `/api/users`

### Response

```json
{
  "status": "success",
  "data": [
    {
      "id": "fa50cebb-1a1c-4451-9a09-6170b216e72e",
      "name": "Choirul Amir Siregar",
      "age": 25
    }
  ]
}
```

---

## ✅ Status Response Format

Semua response menggunakan format standar:

```json
{
  "status": "success",
  "message": "optional message",
  "data": {}
}
```


TAMPILAN WEBSITE 
<img width="1910" height="968" alt="image" src="https://github.com/user-attachments/assets/d2f5f532-17b5-4513-a4c0-51272600d837" />


