# 🚗 Vehicle Rental System — Project Log

> এই file-এ প্রতিটি feature add হওয়ার সাথে সাথে update করা হবে।

---

## ✅ Feature 1 — Project Setup
**Date:** 2026-07-22

### কী করা হয়েছে:
- Initial project structure তৈরি করা হয়েছে।
- তিনটি package তৈরি করা হয়েছে: `model`, `service`, `ui`
- `Main.java` কে application entry point হিসেবে set করা হয়েছে।
- Run করলে একটি welcome banner দেখাবে।

### Files:
| File | কাজ |
|------|-----|
| `Main.java` | Application entry point — welcome banner print করে |
| `model/package-info.java` | model package placeholder |
| `service/package-info.java` | service package placeholder |
| `ui/package-info.java` | ui package placeholder |

### Output:
```
====================================
      VEHICLE RENTAL SYSTEM
            Version 1.0
====================================
```

---

## ✅ Feature 2 — Welcome Menu (CLI)
**Date:** 2026-07-22

### কী করা হয়েছে:
- `ui/MainMenu.java` তৈরি করা হয়েছে।
- `Main.java` শুধু `MainMenu` object তৈরি করে `start()` call করে — বাকি সব logic `MainMenu`-তে।
- Welcome banner দেখানো হয়।
- 4টি option সহ menu loop চলে।
- Option 1, 2, 3 → `"Feature Coming Soon..."` print করে।
- Option 0 → goodbye message দিয়ে exit।
- Invalid number বা character input দিলে crash হয় না — safe validation আছে।

### Files:
| File | কাজ |
|------|-----|
| `Main.java` | শুধু `MainMenu` তৈরি করে `start()` call করে |
| `ui/MainMenu.java` | সব menu logic এখানে — banner, loop, switch-case, input validation |

### গুরুত্বপূর্ণ Design সিদ্ধান্ত:
- `scanner.nextLine()` ব্যবহার করা হয়েছে `nextInt()` এর বদলে — character input-এ crash হয় না।
- `isInteger()` helper method দিয়ে input parse করার আগে validate করা হয়।
- `while(running)` boolean flag দিয়ে loop exit করা — `while(true) + break` এর চেয়ে cleaner।
- `printWelcomeBanner()` ও `printMenu()` আলাদা private method — single responsibility।

### Output:
```
====================================
      VEHICLE RENTAL SYSTEM
            Version 1.0
====================================

------------------------------------
           MAIN MENU
------------------------------------
  1. Admin Login
  2. Customer Login
  3. Customer Registration
  0. Exit
------------------------------------
Enter your choice:
```

---

## ✅ Feature 3 — Admin Login
**Date:** 2026-07-22

### কী করা হয়েছে:
- `model/Admin.java` তৈরি করা হয়েছে — default credentials ও `login()` method সহ।
- `ui/MainMenu.java`-এ option 1 এখন real Admin Login করে।
- Username ও password console থেকে নেওয়া হয়।
- Correct credentials হলে → `"Login Successful!"` দেখায়।
- Wrong credentials হলে → `"Invalid Username or Password."` দেখায়।
- Login attempt শেষে Main Menu-তে ফিরে আসে।

### Files:
| File | পরিবর্তন |
|------|-----------|
| `model/Admin.java` | **নতুন** — `username`, `password` field ও `login()` method |
| `ui/MainMenu.java` | **Modified** — case 1 এ `handleAdminLogin()` call; নতুন private method যোগ |

### Default Credentials:
| Field | Value |
|-------|-------|
| Username | `admin` |
| Password | `admin123` |

### গুরুত্বপূর্ণ Design সিদ্ধান্ত:
- `Admin` object `handleAdminLogin()` এর ভেতরে তৈরি করা হয় — simple ও beginner-friendly।
- `login()` method শুধু `true`/`false` return করে — UI logic model থেকে আলাদা রাখা হয়েছে।
- `handleAdminLogin()` private method হিসেবে `MainMenu`-এ রাখা হয়েছে — separation of concern।
- Admin Dashboard এখনো তৈরি হয়নি — পরবর্তী feature-এ হবে।

### Output (সঠিক login):
```
------------------------------------
           ADMIN LOGIN
------------------------------------
Username: admin
Password: admin123

[✔] Login Successful!
```

### Output (ভুল login):
```
[✘] Invalid Username or Password.
```

---

## ✅ Feature 4 — Customer Registration
**Date:** 2026-07-22

### কী করা হয়েছে:
- `model/Customer.java` তৈরি — 5টি field, constructor, getters ও setters সহ।
- `service/CustomerService.java` তৈরি — `ArrayList<Customer>` ও `registerCustomer()` method সহ।
- `ui/MainMenu.java`-এ option 3 এখন real Customer Registration করে।
- Console থেকে Full Name, Phone Number, Username, Password নেওয়া হয়।
- Registration সফল হলে `"Customer Registered Successfully!"` দেখায়।
- Registration শেষে Main Menu-তে ফিরে আসে।

### Files:
| File | পরিবর্তন |
|------|-----------|
| `model/Customer.java` | **নতুন** — 5 field, constructor, getters/setters |
| `service/CustomerService.java` | **নতুন** — ArrayList, auto-increment ID, `registerCustomer()` |
| `ui/MainMenu.java` | **Modified** — `CustomerService` field যোগ; case 3 → `registerCustomer()` call |

### গুরুত্বপূর্ণ Design সিদ্ধান্ত:
- `Scanner` object `MainMenu` থেকে `registerCustomer(scanner)` এ pass করা হয় — একটিমাত্র Scanner ব্যবহার হয়, conflict নেই।
- `customerId` auto-increment করে `nextId` counter দিয়ে — simple ও beginner-friendly।
- `getCustomerList()` রাখা হয়েছে ভবিষ্যতে Customer Login ও listing-এর জন্য।
- File handling নেই — সব data in-memory `ArrayList`-এ থাকে।

### Output:
```
------------------------------------
     CUSTOMER REGISTRATION
------------------------------------
Full Name     : John Doe
Phone Number  : 01712345678
Username      : john123
Password      : pass123

[✔] Customer Registered Successfully!
```

---

## ✅ Feature 3 — Development Checklist

| # | Item | Status |
|---|------|--------|
| 1 | `Customer.java` created | ✅ |
| 2 | `CustomerService.java` created | ✅ |
| 3 | Customer model completed (5 fields + getters/setters) | ✅ |
| 4 | `ArrayList<Customer>` implemented | ✅ |
| 5 | `registerCustomer()` implemented | ✅ |
| 6 | MainMenu option 3 connected | ✅ |
| 7 | Registration success message displayed | ✅ |
| 8 | Returns to Main Menu | ✅ |
| 9 | No file handling used | ✅ |
| 10 | No future features implemented | ✅ |
| 11 | Code compiles successfully | ✅ **BUILD SUCCESS** |

---

## ✅ Feature 5 — Customer Login
**Date:** 2026-07-22

### কী করা হয়েছে:
- `service/CustomerService.java`-এ `loginCustomer()` method যোগ করা হয়েছে।
- Console থেকে username ও password নেওয়া হয়।
- `ArrayList<Customer>` loop করে match খোঁজা হয়।
- Match পেলে → `"Login Successful!"`, না পেলে → `"Invalid Username or Password."`
- `ui/MainMenu.java`-এ option 2 এখন Customer Login করে।
- Login attempt শেষে Main Menu-তে ফিরে আসে।

### Files:
| File | পরিবর্তন |
|------|-----------|
| `service/CustomerService.java` | **Modified** — `loginCustomer()` method যোগ |
| `ui/MainMenu.java` | **Modified** — case 2 → `customerService.loginCustomer(scanner)` call |

### গুরুত্বপূর্ণ Design সিদ্ধান্ত:
- Enhanced `for` loop দিয়ে ArrayList search — beginner-friendly ও readable।
- Match পাওয়া মাত্র `return` করা হয় — অপ্রয়োজনীয় iteration বন্ধ।
- Customer Dashboard তৈরি করা হয়নি — পরবর্তী feature-এ হবে।
- File handling ব্যবহার করা হয়নি।

### Output (সঠিক login):
```
------------------------------------
        CUSTOMER LOGIN
------------------------------------
Username : john123
Password : pass123

[✔] Login Successful!
```

### Output (ভুল login):
```
[✘] Invalid Username or Password.
```

---

## ✅ Feature 5 — Development Checklist

| # | Item | Status |
|---|------|--------|
| 1 | `loginCustomer()` method added | ✅ |
| 2 | Username validation implemented | ✅ |
| 3 | Password validation implemented | ✅ |
| 4 | MainMenu option 2 connected | ✅ |
| 5 | Login success message displayed | ✅ |
| 6 | Login failure message displayed | ✅ |
| 7 | Returns to Main Menu | ✅ |
| 8 | No file handling used | ✅ |
| 9 | No future features implemented | ✅ |
| 10 | Code compiles successfully | ✅ **BUILD SUCCESS** |

---

<!-- নতুন feature add হলে এখানে নিচে একইভাবে যোগ করা হবে -->

---

## ✅ Feature 5.5 — OOP Refactor (Person Base Class)
**Date:** 2026-07-22

### কী করা হয়েছে:
- `model/Person.java` তৈরি — common fields (`id`, `fullName`, `username`, `password`) এখানে রাখা হয়েছে।
- `Admin` এখন `Person` extends করে — duplicate fields সরানো হয়েছে।
- `Customer` এখন `Person` extends করে — শুধু `phoneNumber` Customer-specific field হিসেবে রেখেছে।
- কোনো existing behavior পরিবর্তন হয়নি — Admin Login, Customer Login, Customer Registration সব আগের মতো কাজ করে।

### Inheritance Hierarchy:
```
Person
├── Admin
└── Customer
```

### Files:
| File | পরিবর্তন |
|------|-----------|
| `model/Person.java` | **নতুন** — base class: `id`, `fullName`, `username`, `password` |
| `model/Admin.java` | **Refactored** — extends Person, `super(0, "Admin", "admin", "admin123")` |
| `model/Customer.java` | **Refactored** — extends Person, শুধু `phoneNumber` রেখেছে |

### গুরুত্বপূর্ণ Design সিদ্ধান্ত:
- Admin-এর hardcoded credentials `super()` call-এ pass করা হয় — no-arg constructor এখনো কাজ করে।
- `Admin.login()` এখন `getUsername()` ও `getPassword()` (inherited) ব্যবহার করে।
- `CustomerService` একটুও পরিবর্তন হয়নি — `getUsername()`, `getPassword()` এখন Person থেকে inherit হয়।
- `MainMenu` একটুও পরিবর্তন হয়নি।

### Development Checklist:

| # | Item | Status |
|---|------|--------|
| 1 | `Person.java` created | ✅ |
| 2 | Common fields moved to Person | ✅ |
| 3 | Admin extends Person | ✅ |
| 4 | Customer extends Person | ✅ |
| 5 | Constructors updated using `super()` | ✅ |
| 6 | Existing functionality unchanged | ✅ |
| 7 | Customer Registration still works | ✅ |
| 8 | Customer Login still works | ✅ |
| 9 | Admin Login still works | ✅ |
| 10 | Code compiles successfully | ✅ **BUILD SUCCESS** |
| 11 | No future features added | ✅ |

---

<!-- নতুন feature add হলে এখানে নিচে একইভাবে যোগ করা হবে -->

---

## ✅ Feature 6.1 — Vehicle Model Hierarchy
**Date:** 2026-07-22

### কী করা হয়েছে:
- `model/Vehicle.java` তৈরি — abstract base class, 5টি common field সহ।
- `model/Car.java` তৈরি — Vehicle extends করে, `seatCapacity` ও `fuelType` যোগ।
- `model/Bike.java` তৈরি — Vehicle extends করে, `engineCC` যোগ।
- কোনো business logic নেই — শুধু model structure।

### Inheritance Hierarchy:
```
Vehicle (abstract)
├── Car    → seatCapacity, fuelType
└── Bike   → engineCC
```

### Fields Summary:
| Class | Fields |
|-------|--------|
| `Vehicle` | `vehicleId`, `brand`, `model`, `rentPerDay`, `available` |
| `Car` | ↑ + `seatCapacity`, `fuelType` |
| `Bike` | ↑ + `engineCC` |

### Files:
| File | পরিবর্তন |
|------|-----------|
| `model/Vehicle.java` | **নতুন** — abstract base class |
| `model/Car.java` | **নতুন** — extends Vehicle |
| `model/Bike.java` | **নতুন** — extends Vehicle |

### গুরুত্বপূর্ণ Design সিদ্ধান্ত:
- `Vehicle` abstract করা হয়েছে — কেউ সরাসরি `new Vehicle()` করতে পারবে না।
- `available` field boolean — পরে rent করলে `false` হবে, return করলে `true`।
- `VehicleService` এখনো তৈরি হয়নি — পরবর্তী feature-এ হবে।

### Development Checklist:

| # | Item | Status |
|---|------|--------|
| 1 | `Vehicle.java` created | ✅ |
| 2 | Vehicle declared abstract | ✅ |
| 3 | Car extends Vehicle | ✅ |
| 4 | Bike extends Vehicle | ✅ |
| 5 | Constructors implemented | ✅ |
| 6 | Getters/Setters implemented | ✅ |
| 7 | Encapsulation maintained | ✅ |
| 8 | Constructor chaining using `super()` | ✅ |
| 9 | No business logic added | ✅ |
| 10 | Code compiles successfully | ✅ **BUILD SUCCESS** |

---

<!-- নতুন feature add হলে এখানে নিচে একইভাবে যোগ করা হবে -->
