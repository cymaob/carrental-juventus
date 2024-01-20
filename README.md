#Carrenal System "FleetWise"

###Database
- The application needs and mySQL database with to tables for cars and rentals. Tables can be created with the following SQL Statements:
```sql
CREATE TABLE rental (
   id INT AUTO_INCREMENT,
   car_id INT,
   rent_start_date datetime,
   rent_end_date datetime,
   PRIMARY KEY(id),
   FOREIGN KEY (car_id) REFERENCES car(id)
);

CREATE TABLE Car (
   id INT PRIMARY KEY AUTO_INCREMENT,
   brand VARCHAR(255),
   model VARCHAR(255),
   doors INT,
   seats INT,
   transmission VARCHAR(255),
   chassis VARCHAR(255),
   price_per_day DOUBLE
);
```
