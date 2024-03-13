create table if not exists category(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(255),
    description varchar(255)
);

create table if not exists product(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(255), 
    description varchar(255),
    FOREIGN KEY (description) REFERENCES category(description)
    price DOUBLE,
    categoryId INT
);