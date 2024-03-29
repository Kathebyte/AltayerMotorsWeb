/* Innerjoin para trar todos los empleados con todos los datos.*/
select id_employee, employee.name as name, phone_number, address, email, user, job_position.name as job_position, salary, state.name as state
from employee
    inner join state on employee.id_state = state.id_state
    inner join job_position  on employee.id_job_position = job_position.id_job_position;


/*UPDATE vehicle
SET columna = nuevo_valor
WHERE condicion;
  cambiar algun dato
 */
select*from vehicle;
/*eliminar toda la clumnina*/

/*DELETE FROM vehicle*/
WHERE carId = 15;

select * from brand;
select *from make;

insert into accident_history (name) values ('Yes'),('No');
select * from accident_history;
ALTER TABLE type_car AUTO_INCREMENT = 300;

select * from brand;
select * from color;
select * from accident_history;
select* from type_car;

insert into vehicle( id_make, id_brand, year, id_color, prices, miliage, warrantyTime, id_accident_history, id_type_car) values
        (2,2,2022,6,100000,('18000'),('6 years'),2,317);


select carId, make.name as make, brand.name as brand, year ,color.name as color,prices,miliage,warrantyTime,accident_history.name as accident_history,type_car.name as type_car
from vehicle
inner join make  on vehicle.id_make = make.id_make
inner join brand on vehicle.id_brand = brand.id_brand
inner join color  on vehicle.id_color = color.id_color
inner join  accident_history  on vehicle.id_accident_history = accident_history.id_accident_history
inner join  type_car on vehicle.id_type_car = type_car.id_type_car;

DELETE FROM accident_history;
select * from vehicle;

UPDATE vehicle
set id_make=?,
    id_brand=?,
    year=?,
    id_color=?,
    prices=?,
    miliage=?,
    warrantyTime=?,
    accident_history=?,
    id_type_car=?
where carId=?;


UPDATE vehicle
SET accident_history = 0
WHERE carId = 25;

update employee
set state =1
where id_employee = 42;



select * from employee;


# alter table employee
# drop foreign key employee_state_id_state_fk;Eliminar una llave foranea


update employee
set name = ?,
    phone_number=?,
    address=?,
    email=?,
    user=?,
    id_job_position=?,
    salary=?,
    state=?
where id_employee=?;

select id_employee,employee.name,phone_number,address,email,user,job_position.name as job_position,salary,state
from employee
inner join job_position on employee.id_job_position = job_position.id_job_position;


select *
from employee;