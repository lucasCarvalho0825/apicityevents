create table eventos(

  id integer not null auto_increment,
  title varchar(100) not null,
  startDate timestamp not null ,
  endDate timestamp not null,
  description varchar(255) not null ,
  paid integer not null ,
  ageMin integer not null,
  status integer not null ,


  primary key (id)
);