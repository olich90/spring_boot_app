drop table if exists product;

create table if not exists product(
	id bigserial primary key,
	title varchar(255),
	cost float
);

insert into product (title, cost)
values('Notebook Lenovo', 1000),
      ('Notebook Dell', 900),
      ('Notebook Acer', 1100),
      ('Notebook HP', 800),
      ('Notebook Asus', 600),
      ('Notebook Xiaomi', 700),
      ('Notebook Huawei', 800),
      ('Notebook Honor', 650),
      ('Notebook Apple', 750),
      ('Notebook MSI', 850),
      ('Smartphone Xiaomi', 850),
      ('Smartphone Huawei', 850),
      ('Smartphone Apple', 1500),
      ('Keyboard Kreolz', 300),
      ('Mouse A4Tech', 200),
      ('Printer Panasonic', 600),
      ('Monitor Philips', 400),
      ('TV Samsung', 700),
      ('Camera Leica', 1600),
      ('SmartWatch Xiaomi', 200);