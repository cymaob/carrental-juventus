# Carrenal System "FleetWise"

## Technology
The application uses java springboot as backend and angular material in frontend. Persistance layer is a mySQL database. Under "Database" you can find more information about creating the needed tables.

## Component overview frontend
<pre>
└── src
    ├── app
        ├── admin-component
        ├── edit-car-component
        ├── header-component
        ├── home-component
        ├── new-car-component
        ├── rent-component
        └── app-component
</pre>

### Database
- The application needs a mySQL database with two tables for cars and rentals. Tables can be created with the following SQL Statements:
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
